package repository;

import model.Balance;

public class BalanceRepositoryjdbc {
    public Balance findLastBalancebyId(int id_account) throws SQLException {
        String sql = String.format(
                "SELECT * FROM accounts WHERE id = ? ORDER BY %s DESC LIMIT 1 ",
                BalanceModel.TABLE_NAME,
                BalanceModel.ID_ACCOUNT,
                BalanceModel.DATETIME
        );
        PreparedStatement preparedStatement = connectionDB.getConnection().prepareStatement(sql);
        preparedStatement.setInt(1, id_account);
        ResultSet resultSet = preparedStatement.executeQuery();
        return new BalanceModel(
                resultSet.getInt(BalanceModel.ID_ACCOUNT),
                resultSet.getTimestamp(BalanceModel.DATETIME).toLocalDateTime(),
                resultSet.getBigDecimal(BalanceModel.VALUE)
        );
    }
}
