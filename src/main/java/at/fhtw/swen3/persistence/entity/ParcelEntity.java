package at.fhtw.swen3.persistence.entity;

import at.fhtw.swen3.persistence.HopArrival;
import at.fhtw.swen3.persistence.Recipient;
import at.fhtw.swen3.persistence.enums.StateEnum;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ParcelEntity {
    private String trackingId;
    private Float weight;
    private Recipient recipient;
    private Recipient sender;
    private StateEnum state;
    private List<HopArrival> visitedHops = new ArrayList<>();
    private List<HopArrival> futureHops = new ArrayList<>();
}
