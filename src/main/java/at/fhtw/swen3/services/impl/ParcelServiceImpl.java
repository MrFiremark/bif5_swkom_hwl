package at.fhtw.swen3.services.impl;

import at.fhtw.swen3.persistence.entities.ParcelEntity;
import at.fhtw.swen3.persistence.repositories.ParcelRepository;
import at.fhtw.swen3.services.ParcelService;
import at.fhtw.swen3.services.dto.Parcel;
import at.fhtw.swen3.services.mapper.ParcelMapper;
import at.fhtw.swen3.services.mapper.RecipientMapper;
import at.fhtw.swen3.services.validation.ValidatorUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@RequiredArgsConstructor
@Service
@Slf4j
public class ParcelServiceImpl implements ParcelService {

    @Autowired
    private final ParcelRepository parcelRepository;

    @Autowired
    private final ValidatorUtil validatorUtil;

    @Override
    public ParcelEntity submitParcel(Parcel parcelDto){
        ParcelEntity parcelEntity = ParcelMapper.INSTANCE.dtoToEntity(null,parcelDto,null);
        validatorUtil.validate(parcelEntity);
        parcelRepository.save(parcelEntity);
        log.info("New Parcel created!");
        return parcelEntity;
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
