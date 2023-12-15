package repository;

import model.Transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static repository.DBConnection.getConnection;

public class TransactionRepositoryJdbc implements TransactionRepository{
    public void insertTransaction(Transaction transaction, int accountId) {
        String query = "INSERT INTO transaction (label, amount, dateTime, transactionType, accountId) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, transaction.getLabel());
            preparedStatement.setDouble(2, transaction.getAmount());
            preparedStatement.setObject(3, transaction.getDateTime());
            preparedStatement.setObject(4, transaction.getTransactionType());
            preparedStatement.setInt(5, accountId);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static BalanceModel getBalanceAtDateTime(AccountModel accountModel, Timestamp transaction_date) {
        try {
            String sql = String.format(
                    "SELECT * FROM \"%s\" WHERE %s = ? AND %s <= ? ORDER BY %s DESC LIMIT 1",
                    BalanceModel.TABLE_NAME,
                    BalanceModel.ID_ACCOUNT,
                    BalanceModel.DATETIME,
                    BalanceModel.DATETIME
            );
            PreparedStatement preparedStatement = connectionDB.getConnection().prepareStatement(sql);
            preparedStatement.setInt(1, accountModel.getId());
            preparedStatement.setTimestamp(2, Timestamp.valueOf(transaction_date.toLocalDateTime()));
            ResultSet resultSet = preparedStatement.executeQuery();
            BalanceModel balanceModel = new BalanceModel();
            if (resultSet.next()) {
                balanceModel.setId_account(resultSet.getInt(BalanceModel.ID_ACCOUNT));
                balanceModel.setValue(resultSet.getBigDecimal(BalanceModel.VALUE));
                balanceModel.setDatetime(resultSet.getTimestamp(BalanceModel.DATETIME).toLocalDateTime());
                return balanceModel;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
