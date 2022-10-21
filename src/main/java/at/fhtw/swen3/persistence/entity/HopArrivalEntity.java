package at.fhtw.swen3.persistence.entity;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.time.OffsetDateTime;

@Builder
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "T_HOPARRIVAL")
public class HopArrivalEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Pattern(regexp = "^[A-Z]{4}\\d{1,4}$")
    private String code;
    @Pattern(regexp = "^[a-zA-ZßÄÖÜäöü/\\d \\-]*$")
    private String description;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private OffsetDateTime dateTime;

    public boolean checkCode() {
        if(code != "ABCD12")
            return false;
        else
            return true;
    }

    public boolean checkDescription() {
        if(description != "Warehouse 12-27")
            return false;
        else
            return true;
    }
}
