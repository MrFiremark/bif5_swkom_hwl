package at.fhtw.swen3.notification.model;

import at.fhtw.swen3.persistence.entities.ParcelEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Notification {

    private String id;
    private ParcelEntity parcel;
}
