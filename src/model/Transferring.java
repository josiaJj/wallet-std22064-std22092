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
    private int idDebtor;
    private int idCreditor;
    private LocalDateTime datetime;
    private double amount;
}
