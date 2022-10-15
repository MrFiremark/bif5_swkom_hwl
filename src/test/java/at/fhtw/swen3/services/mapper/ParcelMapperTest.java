package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entity.ParcelEntity;
import at.fhtw.swen3.persistence.enums.StateEnum;
import at.fhtw.swen3.services.dto.*;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.OffsetDateTime;

import static org.junit.jupiter.api.Assertions.*;

class ParcelMapperTest {

    private static final Logger log = LoggerFactory.getLogger(ParcelMapperTest.class);

    @Test
    void dtoToEntity() {
        log.info("Test ParcelEntity dtoToEntity()");

        NewParcelInfo newParcelInfoDto = new NewParcelInfo();
        newParcelInfoDto.setTrackingId("PYJRB4HZ6");

        Parcel parcelDto = new Parcel();
        parcelDto.setWeight(11.0f);
        final Recipient recipientDto = new Recipient();
        recipientDto.setName("Tux L. -Oves Azure");
        recipientDto.setStreet("Am Europlatz 3");
        recipientDto.setPostalCode("A-1120");
        recipientDto.setCity("Wien");
        recipientDto.setCountry("Austria");
        parcelDto.setRecipient(recipientDto);
        parcelDto.setSender(recipientDto);

        TrackingInformation trackingInformationDto = new TrackingInformation();
        trackingInformationDto.setState(StateEnum.PICKUP);
        final HopArrival hopArrivalDto = new HopArrival();
        hopArrivalDto.setCode("ABCD12");
        hopArrivalDto.setDescription("Warehouse 12-17");
        hopArrivalDto.setDateTime(OffsetDateTime.now());
        trackingInformationDto.getVisitedHops().add(hopArrivalDto);
        trackingInformationDto.getFutureHops().add(hopArrivalDto);

        ParcelEntity parcelEntity = ParcelMapper.INSTANCE.dtoToEntity(newParcelInfoDto, parcelDto, trackingInformationDto);
        assertEquals(parcelEntity.getTrackingId(), newParcelInfoDto.getTrackingId());
        assertEquals(parcelEntity.getWeight(), parcelDto.getWeight());
        assertEquals(parcelEntity.getRecipient(), parcelDto.getRecipient());
        assertEquals(parcelEntity.getSender(), parcelDto.getSender());
        assertEquals(parcelEntity.getState(), trackingInformationDto.getState());
        assertEquals(parcelEntity.getVisitedHops(), trackingInformationDto.getVisitedHops());
        assertEquals(parcelEntity.getFutureHops(), trackingInformationDto.getFutureHops());
    }

    @Test
    void entityToNewParcelInfoDto() {
        log.info("Test ParcelEntity entityToNewParcelInfoDto()");
        ParcelEntity parcelEntity = new ParcelEntity();
        parcelEntity.setTrackingId("PYJRB4HZ6");
        NewParcelInfo newParcelInfoDto = ParcelMapper.INSTANCE.entityToNewParcelInfoDto(parcelEntity);
        assertEquals(parcelEntity.getTrackingId(), newParcelInfoDto.getTrackingId());
    }

    @Test
    void entityToParcelDto() {
        log.info("Test ParcelEntity entityToParcelDto()");
        ParcelEntity parcelEntity = new ParcelEntity();
        parcelEntity.setWeight(1.1f);
        final Recipient recipientDto = new Recipient();
        recipientDto.setName("Tux L. -Oves Azure");
        recipientDto.setStreet("Am Europlatz 3");
        recipientDto.setPostalCode("A-1120");
        recipientDto.setCity("Wien");
        recipientDto.setCountry("Austria");
        parcelEntity.setRecipient(recipientDto);
        parcelEntity.setSender(recipientDto);
        Parcel parcelDto = ParcelMapper.INSTANCE.entityToParcelDto(parcelEntity);
        assertEquals(parcelEntity.getWeight(), parcelDto.getWeight());
        assertEquals(parcelEntity.getRecipient(), parcelDto.getRecipient());
        assertEquals(parcelEntity.getSender(), parcelDto.getSender());
    }

    @Test
    void entityToTrackingInformationDto() {
        log.info("Test ParcelEntity entityToTrackingInformationDto()");
        ParcelEntity parcelEntity = new ParcelEntity();
        parcelEntity.setState(StateEnum.PICKUP);
        final HopArrival hopArrivalDto = new HopArrival();
        hopArrivalDto.setCode("ABCD12");
        hopArrivalDto.setDescription("Warehouse 12-17");
        hopArrivalDto.setDateTime(OffsetDateTime.now());
        parcelEntity.getVisitedHops().add(hopArrivalDto);
        parcelEntity.getFutureHops().add(hopArrivalDto);
        TrackingInformation trackingInformationDto = ParcelMapper.INSTANCE.entityToTrackingInformationDto(parcelEntity);
        assertEquals(parcelEntity.getState(), trackingInformationDto.getState());
        assertEquals(parcelEntity.getVisitedHops(), trackingInformationDto.getVisitedHops());
        assertEquals(parcelEntity.getFutureHops(), trackingInformationDto.getFutureHops());
    }
}