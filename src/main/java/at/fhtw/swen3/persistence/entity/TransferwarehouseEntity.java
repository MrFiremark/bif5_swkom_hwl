package at.fhtw.swen3.persistence.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "T_TRANSFERWAREHOUSE")
public class TransferwarehouseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String regionGeoJson;

    private String logisticsPartner;

    private String logisticsPartnerUrl;
}
