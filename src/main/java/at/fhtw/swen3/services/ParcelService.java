package at.fhtw.swen3.services;

import at.fhtw.swen3.persistence.entities.ParcelEntity;
import at.fhtw.swen3.services.dto.Parcel;
import org.springframework.stereotype.Service;

@Service
public interface ParcelService {

    ParcelEntity submitParcel(Parcel parcelDto);
    ParcelEntity getParcelState(String trackingId);
    ParcelEntity transferParcel(Parcel parcelDto, String trackingId);
}
