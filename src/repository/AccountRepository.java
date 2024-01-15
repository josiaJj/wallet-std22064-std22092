package repository;

import model.Account;
import model.TransactionType;

import java.sql.SQLException;

public interface AccountRepository {
    Account updateAccountBalance(Account account);
}
