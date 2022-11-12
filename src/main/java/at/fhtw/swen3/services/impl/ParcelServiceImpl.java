package at.fhtw.swen3.services.impl;

import at.fhtw.swen3.persistence.entities.ParcelEntity;
import at.fhtw.swen3.persistence.repository.ParcelRepository;
import at.fhtw.swen3.services.ParcelService;
import at.fhtw.swen3.services.RecipientService;
import at.fhtw.swen3.services.dto.Parcel;
import at.fhtw.swen3.services.mapper.ParcelMapper;
import at.fhtw.swen3.services.mapper.RecipientMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.NativeWebRequest;

@RequiredArgsConstructor
@Service
public class ParcelServiceImpl implements ParcelService {

    @Autowired
    private ParcelRepository parcelRepository;

    @Override
    public ParcelEntity submitParcel(Parcel parcelDto){
        ParcelEntity parcelEntity = ParcelMapper.INSTANCE.dtoToEntity(null,parcelDto,null);
        // Validation
        parcelRepository.save(parcelEntity);
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
        // Validation
        parcelEntity.setRecipient(RecipientMapper.INSTANCE.dtoToEntity(parcelDto.getRecipient()));
        parcelEntity.setSender(RecipientMapper.INSTANCE.dtoToEntity(parcelDto.getSender()));
        parcelRepository.save(parcelEntity);
        return parcelEntity;
    }


}
