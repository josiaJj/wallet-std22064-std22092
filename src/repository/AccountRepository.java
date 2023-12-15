package repository;

import model.Account;

import java.sql.SQLException;

public interface AccountRepository {
    Account findById(int id);
    void updateAccountBalance(Account account);
}
