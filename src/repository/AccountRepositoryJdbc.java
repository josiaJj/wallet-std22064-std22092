package repository;

import model.Account;
import model.AccountType;
import model.Currency;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountRepositoryJdbc implements AccountRepository, CrudOperationsBases<Account>{
    public Account findById(int id) {
        return null;
    }
    @Override
    public List<Account> findAll() throws SQLException {
        String sql = "SELECT\n" +
                "    a.id AS account_id,\n" +
                "    a.name AS account_name,\n" +
                "    a.balance AS account_balance,\n" +
                "    c.name AS currency_name,\n" +
                "    account_type\n" +
                "FROM\n" +
                "    accounts a\n" +
                "JOIN\n" +
                "    currency c ON a.currency_id = c.id;";
        Account account = new Account();
        List<Account> allAccounts = new ArrayList<>();
        ResultSet resultSet = DBConnection.getConnection().prepareStatement(sql).executeQuery();
        while (resultSet.next()){
            account.setId(resultSet.getInt("account_id"));
            account.setName(resultSet.getString("account_name"));
            account.setBalance(resultSet.getDouble("account_balance"));
            account.setCurrency((Currency) resultSet.getObject("currency_name"));
            account.setAccountType((AccountType) resultSet.getObject("account_type"));
            allAccounts.add(account);
        }
        return allAccounts;
    }

    @Override
    public List<Account> saveAll(List<Account> toSave) {
        return null;
    }

    @Override
    public Account save(Account toSave) {
        String sql = ("INSERT INTO accounts (name, balance, currency_id, account_type)\n" +
                        "VALUES (?, ?, (SELECT id FROM currency WHERE code = ?), ?);");
        try (PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(sql)) {
            preparedStatement.setString(1, toSave.getName());
            preparedStatement.setDouble(2, toSave.getBalance());
            preparedStatement.setObject(3, toSave.getCurrency());
            preparedStatement.setObject(4, toSave.getAccountType());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public void updateAccountBalance(Account account) {
        String query = "UPDATE account SET balance = ? WHERE id = ?";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setDouble(1, account.getBalance());
            preparedStatement.setInt(2, account.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
