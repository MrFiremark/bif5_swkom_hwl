package at.fhtw.swen3.services;

import at.fhtw.swen3.persistence.entities.ParcelEntity;
import at.fhtw.swen3.services.dto.Parcel;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolationException;
import java.io.IOException;

@Service
public interface ParcelService {

    String submitParcel(Parcel parcelDto) throws ConstraintViolationException, IOException, InterruptedException;

    String transferParcel(String trackingId, Parcel parcelDto) throws IOException, InterruptedException;
    void reportParcelDelivery(String trackingId) throws IOException, InterruptedException;
    ParcelEntity getParcelState(String trackingId);

}
