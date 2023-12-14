package service;

import model.Account;
import model.TransactionType;

public interface AccountService {
    Account performTransaction(int accountId, double amount, TransactionType transactionType);
}
