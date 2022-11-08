package at.fhtw.swen3.persistence.entities;

import at.fhtw.swen3.persistence.enums.StateEnum;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import java.util.ArrayList;
import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "T_PARCEL")
public class ParcelEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String trackingId;
    @DecimalMin("0.0")
    private Float weight;

    @OneToOne
    private RecipientEntity recipient;

    @OneToOne
    private RecipientEntity sender;

    private StateEnum state;

    @OneToMany
    private List<HopArrivalEntity> visitedHops = new ArrayList<>();

    @OneToMany
    private List<HopArrivalEntity> futureHops = new ArrayList<>();

    public boolean checkWeight() {
        if (weight < 0)
            return false;
        else
            return true;
    }

    public boolean checkTrackingId() {
        if (trackingId != "A12007895")
            return false;
        else
            return true;
    }
}
