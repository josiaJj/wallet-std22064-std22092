package model;

import lombok.*;

import java.sql.Date;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Transaction {
    private int id;
    private String label;
    private double amount;
    private String type;
    private LocalDateTime dateTime;
    private TransactionType transactionType;
    private int accountId;
    private int categoryId;
}
