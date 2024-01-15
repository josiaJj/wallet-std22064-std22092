package repository;

import model.Account;
import model.Transaction;
import model.TransactionType;

public interface TransactionRepository {
    Account doTransaction(String accountId, TransactionType transactionType);
    void insertTransaction(Transaction transaction, int accountId);
}
