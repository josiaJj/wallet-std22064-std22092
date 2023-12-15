package service;

import model.Account;
import model.TransactionType;

import java.sql.SQLException;

public interface TransactionService {
    public Account performTransaction(int accountId, double amount, TransactionType transactionType) throws SQLException;
}
