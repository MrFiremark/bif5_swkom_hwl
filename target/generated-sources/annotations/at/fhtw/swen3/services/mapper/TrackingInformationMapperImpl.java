package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entity.ParcelEntity;
import at.fhtw.swen3.services.dto.TrackingInformationDto;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-10-07T12:21:49+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
public class TrackingInformationMapperImpl implements TrackingInformationMapper {

    @Override
    public ParcelEntity dtoToEntity(TrackingInformationDto newParcelInfoDto) {
        if ( newParcelInfoDto == null ) {
            return null;
        }

        ParcelEntity parcelEntity = new ParcelEntity();

        return parcelEntity;
    }

    @Override
    public TrackingInformationDto entityToDto(ParcelEntity parcel) {
        if ( parcel == null ) {
            return null;
        }

        TrackingInformationDto trackingInformationDto = new TrackingInformationDto();

        return trackingInformationDto;
    }
}
