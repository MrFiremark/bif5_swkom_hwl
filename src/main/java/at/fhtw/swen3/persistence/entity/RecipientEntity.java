package at.fhtw.swen3.persistence.entity;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RecipientEntity {
    private String name;
    private String street;
    private String postalCode;
    private String city;
    private String country;
}

