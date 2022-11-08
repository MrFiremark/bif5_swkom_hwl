package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.HopArrivalEntity;
import at.fhtw.swen3.persistence.entities.ParcelEntity;
import at.fhtw.swen3.persistence.entities.RecipientEntity;
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
        assertEquals(parcelEntity.getRecipient().getName(), parcelDto.getRecipient().getName());
        assertEquals(parcelEntity.getRecipient().getStreet(), parcelDto.getRecipient().getStreet());
        assertEquals(parcelEntity.getRecipient().getPostalCode(), parcelDto.getRecipient().getPostalCode());
        assertEquals(parcelEntity.getRecipient().getCity(), parcelDto.getRecipient().getCity());
        assertEquals(parcelEntity.getRecipient().getCity(), parcelDto.getRecipient().getCity());
        assertEquals(parcelEntity.getRecipient().getCountry(), parcelDto.getRecipient().getCountry());
        assertEquals(parcelEntity.getSender().getName(), parcelDto.getSender().getName());
        assertEquals(parcelEntity.getSender().getStreet(), parcelDto.getSender().getStreet());
        assertEquals(parcelEntity.getSender().getPostalCode(), parcelDto.getSender().getPostalCode());
        assertEquals(parcelEntity.getSender().getCity(), parcelDto.getSender().getCity());
        assertEquals(parcelEntity.getSender().getCity(), parcelDto.getSender().getCity());
        assertEquals(parcelEntity.getSender().getCountry(), parcelDto.getSender().getCountry());
        assertEquals(parcelEntity.getState(), trackingInformationDto.getState());
        assertEquals(parcelEntity.getVisitedHops().get(0).getCode(), trackingInformationDto.getVisitedHops().get(0).getCode());
        assertEquals(parcelEntity.getVisitedHops().get(0).getDateTime(), trackingInformationDto.getVisitedHops().get(0).getDateTime());
        assertEquals(parcelEntity.getVisitedHops().get(0).getDescription(), trackingInformationDto.getVisitedHops().get(0).getDescription());
        assertEquals(parcelEntity.getFutureHops().get(0).getCode(), trackingInformationDto.getFutureHops().get(0).getCode());
        assertEquals(parcelEntity.getFutureHops().get(0).getDateTime(), trackingInformationDto.getFutureHops().get(0).getDateTime());
        assertEquals(parcelEntity.getFutureHops().get(0).getDescription(), trackingInformationDto.getFutureHops().get(0).getDescription());
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

        final RecipientEntity recipient = new RecipientEntity();
        recipient.setName("Tux L. -Oves Azure");
        recipient.setStreet("Am Europlatz 3");
        recipient.setPostalCode("A-1120");
        recipient.setCity("Wien");
        recipient.setCountry("Austria");
        parcelEntity.setRecipient(recipient);
        parcelEntity.setSender(recipient);

        Parcel parcelDto = ParcelMapper.INSTANCE.entityToParcelDto(parcelEntity);
        assertEquals(parcelEntity.getWeight(), parcelDto.getWeight());
        assertEquals(parcelEntity.getRecipient().getName(), parcelDto.getRecipient().getName());
        assertEquals(parcelEntity.getRecipient().getStreet(), parcelDto.getRecipient().getStreet());
        assertEquals(parcelEntity.getRecipient().getPostalCode(), parcelDto.getRecipient().getPostalCode());
        assertEquals(parcelEntity.getRecipient().getCity(), parcelDto.getRecipient().getCity());
        assertEquals(parcelEntity.getRecipient().getCity(), parcelDto.getRecipient().getCity());
        assertEquals(parcelEntity.getRecipient().getCountry(), parcelDto.getRecipient().getCountry());
        assertEquals(parcelEntity.getSender().getName(), parcelDto.getSender().getName());
        assertEquals(parcelEntity.getSender().getStreet(), parcelDto.getSender().getStreet());
        assertEquals(parcelEntity.getSender().getPostalCode(), parcelDto.getSender().getPostalCode());
        assertEquals(parcelEntity.getSender().getCity(), parcelDto.getSender().getCity());
        assertEquals(parcelEntity.getSender().getCity(), parcelDto.getSender().getCity());
        assertEquals(parcelEntity.getSender().getCountry(), parcelDto.getSender().getCountry());

    }

    @Test
    void entityToTrackingInformationDto() {
        log.info("Test ParcelEntity entityToTrackingInformationDto()");
        ParcelEntity parcelEntity = new ParcelEntity();
        parcelEntity.setState(StateEnum.PICKUP);
        final HopArrivalEntity hopArrival = new HopArrivalEntity();
        hopArrival.setCode("ABCD12");
        hopArrival.setDescription("Warehouse 12-17");
        hopArrival.setDateTime(OffsetDateTime.now());
        parcelEntity.getVisitedHops().add(hopArrival);
        parcelEntity.getFutureHops().add(hopArrival);
        TrackingInformation trackingInformationDto = ParcelMapper.INSTANCE.entityToTrackingInformationDto(parcelEntity);
        assertEquals(parcelEntity.getState(), trackingInformationDto.getState());
        assertEquals(parcelEntity.getVisitedHops().get(0).getCode(), trackingInformationDto.getVisitedHops().get(0).getCode());
        assertEquals(parcelEntity.getVisitedHops().get(0).getDateTime(), trackingInformationDto.getVisitedHops().get(0).getDateTime());
        assertEquals(parcelEntity.getVisitedHops().get(0).getDescription(), trackingInformationDto.getVisitedHops().get(0).getDescription());
        assertEquals(parcelEntity.getFutureHops().get(0).getCode(), trackingInformationDto.getFutureHops().get(0).getCode());
        assertEquals(parcelEntity.getFutureHops().get(0).getDateTime(), trackingInformationDto.getFutureHops().get(0).getDateTime());
        assertEquals(parcelEntity.getFutureHops().get(0).getDescription(), trackingInformationDto.getFutureHops().get(0).getDescription());

    }
}