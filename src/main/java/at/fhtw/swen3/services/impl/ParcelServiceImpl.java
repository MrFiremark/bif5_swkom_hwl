package at.fhtw.swen3.services.impl;

import at.fhtw.swen3.gps.service.GeoEncodingService;
import at.fhtw.swen3.notification.model.Notification;
import at.fhtw.swen3.notification.producer.NotificationProducerController;
import at.fhtw.swen3.notification.service.NotificationService;
import at.fhtw.swen3.persistence.entities.GeoCoordinateEntity;
import at.fhtw.swen3.persistence.entities.HopArrivalEntity;
import at.fhtw.swen3.persistence.entities.ParcelEntity;
import at.fhtw.swen3.persistence.enums.StateEnum;
import at.fhtw.swen3.persistence.repositories.ParcelRepository;
import at.fhtw.swen3.services.ParcelService;
import at.fhtw.swen3.services.dto.Parcel;
import at.fhtw.swen3.services.mapper.ParcelMapper;
import at.fhtw.swen3.services.mapper.RecipientMapper;
import at.fhtw.swen3.services.validation.ValidatorUtil;
import at.fhtw.swen3.util.UuidGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.stereotype.Service;

import javax.persistence.PersistenceException;
import javax.validation.ConstraintViolationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

@RequiredArgsConstructor
@Service
@Slf4j
public class ParcelServiceImpl implements ParcelService {

    @Autowired
    private final ParcelRepository parcelRepository;
    @Autowired
    private final ValidatorUtil validatorUtil;
    @Autowired
    private final GeoEncodingService geoEncodingService;

    @Autowired
    private final NotificationService notificationService;
    /*
    @Autowired
    private final NotificationProducerController notificationProducerController;
     */

    @Override
    public String submitParcel(Parcel parcelDto) throws ConstraintViolationException, IOException, InterruptedException {
        ParcelEntity parcelEntity = ParcelMapper.INSTANCE.dtoToEntity(null,parcelDto,null);
        parcelEntity.setTrackingId(UuidGenerator.generateTrackingId());

        //GeoCoordinateEntity recipientLocation = geoEncodingService.encodeAddress(parcelEntity.getRecipient().getAddress());
        //GeoCoordinateEntity senderLocation = geoEncodingService.encodeAddress(parcelEntity.getSender().getAddress());

        parcelEntity.setState(StateEnum.PICKUP);
        parcelEntity.setVisitedHops(new ArrayList<HopArrivalEntity>());
        parcelEntity.setFutureHops(new ArrayList<HopArrivalEntity>());
        validatorUtil.validate(parcelEntity);
        parcelRepository.save(parcelEntity);
        sendNotification(parcelEntity);
        log.info("New Parcel created!");
        return parcelEntity.getTrackingId();
    }

    @Override
    public String transferParcel(String trackingId, Parcel parcelDto) throws IOException, InterruptedException, PersistenceException {
        if(parcelRepository.findByTrackingId(trackingId) != null){
            throw new PersistenceException();
        }
        ParcelEntity parcelEntity = ParcelMapper.INSTANCE.dtoToEntity(null,parcelDto,null);
        parcelEntity.setTrackingId(trackingId);

        //GeoCoordinateEntity recipientLocation = geoEncodingService.encodeAddress(parcelEntity.getRecipient().getAddress());
        //GeoCoordinateEntity senderLocation = geoEncodingService.encodeAddress(parcelEntity.getSender().getAddress());

        parcelEntity.setState(StateEnum.PICKUP);
        parcelEntity.setVisitedHops(new ArrayList<HopArrivalEntity>());
        parcelEntity.setFutureHops(new ArrayList<HopArrivalEntity>());
        validatorUtil.validate(parcelEntity);
        parcelRepository.save(parcelEntity);
        sendNotification(parcelEntity);
        log.info("Parcel transfer!");
        return parcelEntity.getTrackingId();
    }

    @Override
    public void reportParcelDelivery(String trackingId) throws PersistenceException {
        ParcelEntity parcelEntity = parcelRepository.findByTrackingId(trackingId);
        if(parcelEntity == null){
            throw new PersistenceException();
        }
        parcelEntity.setState(StateEnum.DELIVERED);
        parcelRepository.save(parcelEntity);
        sendNotification(parcelEntity);
        log.info("Parcel delivered!");
    }

    @Override
    public String getParcelState(String trackingId) throws PersistenceException, JsonProcessingException {
        ParcelEntity parcelEntity = parcelRepository.findByTrackingId(trackingId);
        if(parcelEntity == null){
            throw new PersistenceException();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        ArrayNode visitedHopsNode = objectMapper.valueToTree(parcelEntity.getVisitedHops());
        ArrayNode futureHopsNode = objectMapper.valueToTree(parcelEntity.getFutureHops());
        ObjectNode newJson = objectMapper.createObjectNode();
        newJson.put("state", parcelEntity.getState().name());
        newJson.putArray("visitedHops").addAll(visitedHopsNode);
        newJson.putArray("futureHops").addAll(futureHopsNode);
        return objectMapper.writeValueAsString(newJson);
    }

    private void sendNotification(ParcelEntity parcelEntity){
        Notification notification = Notification.builder()
                .id(parcelEntity.getTrackingId())
                .parcel(parcelEntity)
                .build();
        notificationService.sendPushNotification(notification);
    }
}
