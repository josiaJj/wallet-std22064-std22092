package repository;

import model.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AccountRepositoryJdbc implements AccountRepository{
    public Account findById(int id) {
        return null;
    }

    public void updateAccountBalance(Account account) throws SQLException {
        String query = "UPDATE account SET balance = ? WHERE id = ?";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setDouble(1, account.getBalance());
            preparedStatement.setInt(2, account.getId());
            preparedStatement.executeUpdate();
        }
    }

}
