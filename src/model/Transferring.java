package model;

import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Transferring {
    private int id;
    private int transactionDebtor;
    private int transactionCredit;
    private LocalDateTime datetime;
}
