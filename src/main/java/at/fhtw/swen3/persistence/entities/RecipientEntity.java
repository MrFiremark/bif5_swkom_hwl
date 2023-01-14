package at.fhtw.swen3.persistence.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "T_RECIPIENT")
public class RecipientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Pattern(regexp = "^([A-Z][A-Za-z/ßÄÖÜäöü\\- ]*)$")
    private String name;

    @Pattern(regexp = "^([A-Z][A-Za-z0-9/ßÄÖÜäöü ]*)$")
    private String street;
    @Pattern(regexp = "^(A-([0-9]{4}))$")
    private String postalCode;
    @Pattern(regexp = "^([A-Z][A-Za-z/ßÄÖÜäöü\\- ]*)$")
    private String city;

    private String country;

    private String expoPushToken;

    public String getAddress(){
        return street + "," + postalCode + "," + city + "," + country;
    }

}

