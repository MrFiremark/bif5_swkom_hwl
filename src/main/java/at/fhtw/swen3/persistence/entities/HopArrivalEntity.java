package at.fhtw.swen3.persistence.entities;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.OffsetDateTime;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "T_HOPARRIVAL")
public class HopArrivalEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String code;
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
