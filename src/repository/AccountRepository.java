package repository;

import model.Account;
import model.TransactionType;

import java.sql.SQLException;

public interface AccountRepository {
    Account doTransaction(String accountId, TransactionType transactionType);
    Account updateAccountBalance(Account account);
}
