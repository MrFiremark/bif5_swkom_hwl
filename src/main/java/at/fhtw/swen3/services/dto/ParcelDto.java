package at.fhtw.swen3.services.dto;


import at.fhtw.swen3.persistence.Recipient;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ParcelDto {
    private Float weight;
    private Recipient recipient;
    private Recipient sender;
}
