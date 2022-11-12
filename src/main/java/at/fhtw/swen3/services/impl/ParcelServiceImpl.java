package at.fhtw.swen3.services.impl;

import at.fhtw.swen3.persistence.entities.ParcelEntity;
import at.fhtw.swen3.persistence.repository.ParcelRepository;
import at.fhtw.swen3.services.ParcelService;
import at.fhtw.swen3.services.RecipientService;
import at.fhtw.swen3.services.dto.Parcel;
import at.fhtw.swen3.services.mapper.ParcelMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.NativeWebRequest;

@RequiredArgsConstructor
public class ParcelServiceImpl implements ParcelService {

    @Autowired
    private ParcelRepository parcelRepository;

    public ParcelEntity submitParcel(Parcel parcelDto){
        ParcelEntity parcelEntity = ParcelMapper.INSTANCE.dtoToEntity(null,parcelDto,null);
        // Validation
        parcelRepository.save(parcelEntity);
        return parcelEntity;
    }
}
