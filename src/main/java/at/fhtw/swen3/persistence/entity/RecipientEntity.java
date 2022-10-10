package at.fhtw.swen3.persistence.entity;

import lombok.*;

import javax.validation.constraints.Pattern;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RecipientEntity {
    private String name;
    @Pattern(regexp = "^([A-Z][A-Za-z0-9/ßÄÖÜäöü ]*)$")
    private String street;
    @Pattern(regexp = "^(A-([0-9]{4}))$")
    private String postalCode;
    @Pattern(regexp = "^([A-Z][A-Za-z/ßÄÖÜäöü\\- ]*)$")
    private String city;
    private String country;
}

