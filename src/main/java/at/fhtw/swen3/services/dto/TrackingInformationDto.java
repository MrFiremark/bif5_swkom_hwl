package at.fhtw.swen3.services.dto;

import at.fhtw.swen3.persistence.HopArrival;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class TrackingInformationDto {
    private List<HopArrival> visitedHops = new ArrayList<>();
    private List<HopArrival> futureHops = new ArrayList<>();
}
