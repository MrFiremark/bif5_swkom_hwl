package at.fhtw.swen3.persistence.entity;

import at.fhtw.swen3.services.dto.WarehouseNextHops;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "T_WAREHOUSE")
public class WarehouseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Integer level;

    @OneToMany
    private List<WarehouseNextHopsEntity> nextHops = new ArrayList<>();
}
