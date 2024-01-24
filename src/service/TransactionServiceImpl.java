package service;

import model.Account;
import model.AccountType;
import model.Transaction;
import model.TransactionType;
import repository.AccountRepositoryJdbc;
import repository.TransactionRepositoryJdbc;

import java.sql.SQLException;
import java.time.LocalDateTime;

public class TransactionServiceImpl implements TransactionService{
    private final AccountRepositoryJdbc accountRepositoryJdbc;
    private final TransactionRepositoryJdbc transactionRepositoryJdbc;

    public TransactionServiceImpl(AccountRepositoryJdbc accountRepositoryJdbc, TransactionRepositoryJdbc transactionRepositoryJdbc) {
        this.accountRepositoryJdbc = accountRepositoryJdbc;
        this.transactionRepositoryJdbc = transactionRepositoryJdbc;
    }



    @Override
    public Account performTransaction(int accountId, double amount, TransactionType transactionType) throws SQLException {
        Account account = new Account();

        Transaction transaction = new Transaction();
        transaction.setLabel("Transaction");
        transaction.setAmount(amount);
        transaction.setDateTime(LocalDateTime.now());
        transaction.setTransactionType(transactionType);
        transaction.setAccountId(accountId);

        if (TransactionType.Debit.equals(transactionType) && !AccountType.Bank.equals(account.getAccountType())) {
            if (account.getBalance() < amount) {
                throw new IllegalArgumentException("Insufficient funds for debit transaction.");
            }
        }
        if (TransactionType.Credit.equals(transactionType) && AccountType.Bank.equals(account.getAccountType())) {
            account.setBalance(account.getBalance() + amount);
        } else {
            account.setBalance(account.getBalance() - amount);
        }

        account.getListTransactions().add(transaction);
        transactionRepositoryJdbc.insertTransaction(transaction, accountId);
        accountRepositoryJdbc.updateAccountBalance(account);

        return account;
    }
}
