package at.fhtw.swen3.persistence.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "T_TRUCK")
public class TruckEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String regionGeoJson;

    private String numberPlate;
}
