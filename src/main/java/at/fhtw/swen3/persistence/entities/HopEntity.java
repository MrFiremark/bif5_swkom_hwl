package at.fhtw.swen3.persistence.entities;

import at.fhtw.swen3.services.dto.GeoCoordinate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.awt.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "T_HOP")
public class HopEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String hopType;

    @Pattern(regexp = "^[A-Z]{4}\\d{1,4}$")
    private String code;

    private String description;

    private Integer processingDelayMins;

    private String locationName;

    //Was a GeoCoordinate before, but wanted to try something
    @OneToOne
    @NotNull
    private GeoCoordinateEntity locationCoordinates;

}
