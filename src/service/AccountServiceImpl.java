package service;

import model.Account;
import model.Transaction;
import model.TransactionType;
import repository.AccountRepository;
import repository.AccountRepositoryJdbc;

import java.sql.Date;

public class AccountServiceImpl implements AccountService{
    private final AccountRepositoryJdbc accountRepositoryJdbc;
    public AccountServiceImpl(AccountRepositoryJdbc accountRepositoryJdbc) {
        this.accountRepositoryJdbc = accountRepositoryJdbc;
    }
    @Override
    public Account performTransaction(int accountId, double amount, TransactionType transactionType) {
        Account account = accountRepositoryJdbc.findById(accountId);

        // Créer une nouvelle transaction
        Transaction transaction = new Transaction();
        transaction.setAmount(amount);
        transaction.setTransactionType(transactionType);
        transaction.setDateTime(new Date());
        // Set other transaction properties as needed

        // Ajouter la transaction à la liste des transactions du compte
        account.getListTransactions().add(transaction);

        // Mettre à jour le solde en fonction du type de compte
        if (account.getAccountType() == AccountType.Bank || (account.getAccountType() == AccountType.MobileMoney && transactionType == TransactionType.Deb

        return null;
    }
}
