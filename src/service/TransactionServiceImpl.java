package service;

import model.Account;
import model.AccountType;
import model.Transaction;
import model.TransactionType;
import repository.AccountRepositoryJdbc;

import java.sql.SQLException;
import java.time.LocalDateTime;

public class TransactionServiceImpl implements TransactionService{
    private final AccountRepositoryJdbc accountRepositoryJdbc;

    public TransactionServiceImpl(AccountRepositoryJdbc accountRepositoryJdbc) {
        this.accountRepositoryJdbc = accountRepositoryJdbc;
    }

    @Override
    public Account performTransaction(int accountId, double amount, TransactionType transactionType) throws SQLException {
        Account account = new Account();

        Transaction transaction = new Transaction();
        transaction.setId(generateTransactionId());
        transaction.setLabel("Transaction");
        transaction.setAmount(amount);
        transaction.setDateTime(LocalDateTime.now()); // Utilisation de LocalDateTime pour la date actuelle
        transaction.setTransactionType(transactionType);

        if (TransactionType.Debit.equals(transactionType) && !AccountType.Bank.equals(account.getAccountType())) {
            if (account.getBalance() < amount) {
                throw new IllegalArgumentException("Insufficient funds for debit transaction.");
            }
        }
        if (TransactionType.Credit.equals(transactionType) || AccountType.Bank.equals(account.getAccountType())) {
            account.setBalance(account.getBalance() + amount);
        } else {
            account.setBalance(account.getBalance() - amount);
        }

        account.getListTransactions().add(transaction);
        accountRepositoryJdbc.updateAccountBalance(account);

        return account;
    }

    private int generateTransactionId() {
        // Implémentez la logique pour générer un ID unique pour la transaction
        return 0;
    }
}
