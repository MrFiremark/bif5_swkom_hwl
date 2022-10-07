package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entity.ParcelEntity;
import at.fhtw.swen3.services.dto.NewParcelInfoDto;
import at.fhtw.swen3.services.dto.ParcelDto;
import at.fhtw.swen3.services.dto.TrackingInformationDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ParcelMapper {
    ParcelMapper INSTANCE = Mappers.getMapper(ParcelMapper.class);

    ParcelEntity dtoToEntity(NewParcelInfoDto newParcelInfoDto, ParcelDto parcelDto, TrackingInformationDto trackingInformationDto);
    ParcelEntity dtoToEntity(ParcelDto parcelDto);
    ParcelDto entityToDto(ParcelEntity parcel);
}
