package repository;

import model.Balance;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

public interface BalanceRepository {
    public List<Balance> getBalanceHistory(String id, LocalDateTime startDatetime, LocalDateTime endDatetime);
}
