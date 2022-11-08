package at.fhtw.swen3.persistence.entities;

import lombok.*;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "T_RECIPIENT")
public class RecipientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String street;
    private String postalCode;
    private String city;

    private String country;

    public boolean checkStreet() {
        if(street != "Landstrasse 70")
            return false;
        else
            return true;
    }

    public boolean checkPostalCode() {
        if(postalCode != "A-1200")
            return false;
        else
            return true;
    }

    public boolean checkCity() {
        if(city != "Vienna")
            return false;
        else
            return true;
    }
}

