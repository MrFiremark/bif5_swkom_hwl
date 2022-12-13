package at.fhtw.swen3.services.impl;

import at.fhtw.swen3.gps.service.GeoEncodingService;
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
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.validation.ConstraintViolationException;
import java.io.IOException;
import java.util.ArrayList;

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

    @Override
    public String submitParcel(Parcel parcelDto) throws ConstraintViolationException, IOException, InterruptedException {
        ParcelEntity parcelEntity = ParcelMapper.INSTANCE.dtoToEntity(null,parcelDto,null);
        //validatorUtil.validate(parcelEntity);

        parcelEntity.setTrackingId(UuidGenerator.generateTrackingId());

        GeoCoordinateEntity recipientLocation = geoEncodingService.encodeAddress(parcelEntity.getRecipient().getAddress());
        GeoCoordinateEntity senderLocation = geoEncodingService.encodeAddress(parcelEntity.getSender().getAddress());

        parcelEntity.setState(StateEnum.PICKUP);
        parcelEntity.setVisitedHops(new ArrayList<HopArrivalEntity>());
        parcelEntity.setFutureHops(new ArrayList<HopArrivalEntity>());
        parcelRepository.save(parcelEntity);
        log.info("New Parcel created!");
        return parcelEntity.getTrackingId();
    }

    @Override
    public ParcelEntity getParcelState(String trackingId) {
        ParcelEntity parcelEntity = parcelRepository.findByTrackingId(trackingId);
        return parcelEntity;
    }

    @Override
    public ParcelEntity transferParcel(Parcel parcelDto, String trackingId) {
        ParcelEntity parcelEntity = parcelRepository.findByTrackingId(trackingId);
        validatorUtil.validate(parcelEntity);
        parcelEntity.setRecipient(RecipientMapper.INSTANCE.dtoToEntity(parcelDto.getRecipient()));
        parcelEntity.setSender(RecipientMapper.INSTANCE.dtoToEntity(parcelDto.getSender()));
        parcelRepository.save(parcelEntity);
        return parcelEntity;
    }

}
