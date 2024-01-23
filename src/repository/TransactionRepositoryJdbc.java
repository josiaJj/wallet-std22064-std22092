package repository;

import model.Account;
import model.Transaction;
import model.TransactionType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import static repository.DBConnection.getConnection;

public class TransactionRepositoryJdbc implements CrudOperationsBases, TransactionRepository{
    @Override
    public Object findById(int id) {
        String sql = "SELECT * FROM";
        return null;
    }

    @Override
    public List findAll() throws SQLException {
        return null;
    }

    @Override
    public List saveAll(List toSave) {
        return null;
    }

    @Override
    public Object save(Object toSave) {
        return null;
    }

    @Override
    public Object delete(Object toDelete) {
        return null;
    }
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
    public Account doTransaction(String accountId, TransactionType transactionType) {

    }
}
