package at.fhtw.swen3.persistence.entity;

import at.fhtw.swen3.services.dto.HopArrival;
import at.fhtw.swen3.services.dto.Recipient;
import at.fhtw.swen3.persistence.enums.StateEnum;
import lombok.*;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;

@Builder
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "T_PARCEL")
public class ParcelEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Pattern(regexp = "^[A-Z0-9]{9}$")
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
