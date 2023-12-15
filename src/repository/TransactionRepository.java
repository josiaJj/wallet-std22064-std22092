package repository;

import model.Account;
import model.Transaction;
import model.TransactionType;

public interface TransactionRepository {
    void insertTransaction(Transaction transaction, int accountId);
}
