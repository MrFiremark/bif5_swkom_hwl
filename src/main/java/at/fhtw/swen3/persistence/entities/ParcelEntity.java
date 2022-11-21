package at.fhtw.swen3.persistence.entities;

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
@Data
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

    @OneToOne(cascade = {CascadeType.ALL}, mappedBy = "recipient")
    @JoinColumn(name = "recipient_id")
    @NotNull
    private RecipientEntity recipient;

    @OneToOne(cascade = {CascadeType.ALL}, mappedBy = "recipient")
    @JoinColumn(name = "recipient_id")
    @NotNull
    private RecipientEntity sender;

    @NotNull
    private StateEnum state;

    @OneToMany(cascade = {CascadeType.ALL}, orphanRemoval = true)
    @NotNull
    private List<HopArrivalEntity> visitedHops = new ArrayList<>();

    @OneToMany(cascade = {CascadeType.ALL}, orphanRemoval = true)
    @NotNull
    private List<HopArrivalEntity> futureHops = new ArrayList<>();

}
