package repository;

import model.Account;

import java.sql.SQLException;

public interface AccountRepository {
    void updateAccountBalance(Account account);
}
