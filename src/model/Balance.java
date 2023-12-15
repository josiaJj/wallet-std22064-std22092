package model;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Balance {
    private String id;
    private int idAccountId;
    private LocalDateTime updatedDatetime;
    private BigDecimal value;
}
