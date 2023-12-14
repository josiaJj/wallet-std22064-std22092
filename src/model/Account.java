package model;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private int id;
    private String name;
    private double balance;
    private List<Transaction> listTransactions = new ArrayList<>();
    private Currency currency;
    private AccountType accountType;
}
