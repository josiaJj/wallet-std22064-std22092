package repository;

import model.Account;
import model.AccountType;
import model.Currency;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class AccountRepositoryJdbc implements AccountRepository, CrudOperationsBases<Account>{
    public Account findById(int id) {
        return null;
    }
    @Override
    public List<Account> findAll() throws SQLException {
        String sql = "SELECT * FROM accounts ";
        Account account = new Account();
        List<Account> allAccounts = new ArrayList<>();
        ResultSet resultSet = DBConnection.getConnection().prepareStatement(sql).executeQuery();
        while (resultSet.next()){
            account.setId(resultSet.getInt("account_id"));
            account.setName(resultSet.getString("account_name"));
            account.setBalance(resultSet.getDouble("account_balance"));
            account.setUpdatedDate((LocalDateTime) resultSet.getObject("updated_date"));
            account.setIdCurrency(resultSet.getInt("id_currency"));
            account.setAccountType((AccountType) resultSet.getObject("account_type"));
            allAccounts.add(account);
        }
        return allAccounts;
    }

    @Override
    public List<Account> saveAll(List<Account> toSave) {
        String sql = "INSERT INTO accounts (name , updated_date , id_currency , account_type) VALUES (?,?,?,?)";
        List<Account> savedAccounts = new ArrayList<>();
        try(PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(sql)){
            for (Account account : toSave){
                preparedStatement.setString(1, account.getName());
                preparedStatement.setObject(2, account.getUpdatedDate());
                preparedStatement.setInt(3, account.getIdCurrency());
                preparedStatement.setObject(4 , account.getAccountType());

                int rowAffected = preparedStatement.executeUpdate();
                if (rowAffected > 0){
                    savedAccounts.add(account);
                }
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return savedAccounts;
    }

    @Override
    public Account save(Account toSave) {
        String sql = "INSERT INTO accounts (name , updated_date , id_currency , account_type) VALUES (?,?,?,?) ";
        try (PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(sql)) {
            preparedStatement.setString(1, toSave.getName());
            preparedStatement.setObject(2,toSave.getUpdatedDate());
            preparedStatement.setInt(3, toSave.getIdCurrency());
            preparedStatement.setObject(4 , toSave.getAccountType());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return toSave;
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
