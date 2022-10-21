package at.fhtw.swen3.persistence.entity;

import at.fhtw.swen3.services.dto.Hop;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "T_WAREHOUSENEXTHOPS")
public class WarehouseNextHopsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Integer traveltimeMins;

    @OneToOne
    private HopEntity hop;
}
