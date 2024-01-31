package repository;

import model.Balance;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class BalanceRepositoryjdbc implements CrudOperationsBases<Balance> {
    public Balance findById(int id) {
        return null;
    };
    public List<Balance> findAll() {
        return null;
    };
    public List<Balance> saveAll(List<Balance> toSave) {
        return null;
    };
    public Balance save(Balance toSave) {
        String sql = "INSERT INTO balance(\"value\")\n" +
                "VALUES (?)";
        try (PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(sql)) {
            preparedStatement.setFloat(toSave.getValue());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return toSaveGIT SATUS;
    };
    public Balance delete(Balance toDelete) {
        return null;
    };
    /*
    public static Balance getBalanceAtDateTime(int accountId, LocalDateTime transactionDatetime) {
        try {
            String sql = "SELECT \"value\"\n" +
                    "            FROM balance_hitory\n" +
                    "            WHERE updateDateTime = ? AND accountId = ?";

            PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(sql);
            preparedStatement.setTimestamp(1, Timestamp.valueOf(transactionDatetime));
            preparedStatement.setInt(2, accountId);
            ResultSet resultSet = preparedStatement.executeQuery();
            Balance balance = new Balance();
            if (resultSet.next()) {
                balance.setAccountId(resultSet.getInt(balance.getAccountId()));
                balance.setUpdatedDatetime((LocalDateTime) resultSet.getObject("updateDateTime"));
                balance.setValue(resultSet.getBigDecimal("value"));

                // save(balance); TODO
                return balance;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
    */
    /*
    public List<Balance> getBalanceHistory(String id, LocalDateTime startDatetime, LocalDateTime endDatetime) {
        String sql;
        if (startDatetime == null && endDatetime == null) {
            sql = "SELECT * FROM \"balance_history\" WHERE accountid = ?;";
        } else {
            sql = "SELECT * FROM \"balance_history\" WHERE accountid = ? " +
                    " AND updatedatetime BETWEEN ? AND ? ;";
        }

        List<Balance> responseSQL = new ArrayList<>();

        try {
            PreparedStatement preSt = DBConnection.getConnection().prepareStatement(sql);
            preSt.setObject(1, UUID.fromString(id));

            if (startDatetime != null && endDatetime != null) {
                preSt.setObject(2, startDatetime);
                preSt.setObject(3, endDatetime);
            }

            ResultSet resultSet = preSt.executeQuery();

            while (resultSet.next()) {
                responseSQL.add(new Balance(
                        resultSet.getString("id"),
                        resultSet.getInt("value"),
                        (LocalDateTime) resultSet.getObject("updatedatetime"),
                        resultSet.getBigDecimal("accountid")
                ));
            }

            return responseSQL;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    */
}
