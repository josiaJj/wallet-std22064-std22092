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
}
