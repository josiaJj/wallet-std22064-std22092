package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Account {
    private int id;
    private String name;
    private double balance;
    private LocalDateTime updatedDate;
    private List<Transaction> listTransactions = new ArrayList<>();
    private int idCurrency;
    private AccountType accountType;
}
