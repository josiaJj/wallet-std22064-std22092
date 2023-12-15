package model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Currency {
    private int id;
    private String name;
    private String code;
}
