package at.fhtw.swen3.persistence.entity;

import at.fhtw.swen3.services.dto.HopArrival;
import at.fhtw.swen3.services.dto.Recipient;
import at.fhtw.swen3.persistence.enums.StateEnum;
import lombok.*;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ParcelEntity {
    @Pattern(regexp = "^[A-Z0-9]{9}$")
    private String trackingId;
    @DecimalMin("0.0")
    private Float weight;
    @NotNull
    private Recipient recipient;
    // TODO oder Valid
    @NotNull
    private Recipient sender;
    private StateEnum state;
    @NotNull
    private List<HopArrival> visitedHops = new ArrayList<>();
    @NotNull
    private List<HopArrival> futureHops = new ArrayList<>();
}
