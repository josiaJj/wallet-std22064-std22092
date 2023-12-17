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

public class BalanceRepositoryjdbc {
    public static Balance getBalanceAtDateTime(Account accountModel, Timestamp transaction_date) {
        try {
            String sql = String.format(
                    "SELECT * FROM \"%s\" WHERE %s = ? AND %s <= ? ORDER BY %s DESC LIMIT 1",
                    Balance.TABLE_NAME,
                    Balance.ID_ACCOUNT,
                    Balance.DATETIME,
                    Balance.DATETIME
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
                        resultSet.getInt("id"),
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
}
