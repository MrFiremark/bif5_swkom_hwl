package at.fhtw.swen3.persistence.entity;

import at.fhtw.swen3.services.dto.GeoCoordinate;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.awt.*;

@Entity
@Table(name = "T_HOP")
public class HopEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String hopType;

    private String code;

    private String description;

    private Integer processingDelayMins;

    private String locationName;

    //Was a GeoCoordinate before, but wanted to try something
    private Point locationCoordinates;

}
