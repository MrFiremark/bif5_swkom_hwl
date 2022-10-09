package at.fhtw.swen3.persistence.entity;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Pattern;
import java.time.OffsetDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class HopArrivalEntity {
    // TODO messages dazu?
    // TODO gab es schon in HopArrival, vlt dort löschen
    @Pattern(regexp = "^[A-Z]{4}\\d{1,4}$")
    private String code;
    // TODO Am anfagn nur Buchstaben und dann nur Zahlen und der rest?
    @Pattern(regexp = "^[a-zA-Z\\d\\s-]+$")
    private String description;

    // TODO Brauch man das?
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private OffsetDateTime dateTime;
}
