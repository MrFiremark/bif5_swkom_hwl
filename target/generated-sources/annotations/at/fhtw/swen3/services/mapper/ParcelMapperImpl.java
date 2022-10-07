package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.HopArrival;
import at.fhtw.swen3.persistence.entity.ParcelEntity;
import at.fhtw.swen3.services.dto.NewParcelInfoDto;
import at.fhtw.swen3.services.dto.ParcelDto;
import at.fhtw.swen3.services.dto.TrackingInformationDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-10-07T12:25:21+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
public class ParcelMapperImpl implements ParcelMapper {

    @Override
    public ParcelEntity dtoToEntity(NewParcelInfoDto newParcelInfoDto, ParcelDto parcelDto, TrackingInformationDto trackingInformationDto) {
        if ( newParcelInfoDto == null && parcelDto == null && trackingInformationDto == null ) {
            return null;
        }

        ParcelEntity parcelEntity = new ParcelEntity();

        if ( newParcelInfoDto != null ) {
            parcelEntity.setTrackingId( newParcelInfoDto.getTrackingId() );
        }
        if ( parcelDto != null ) {
            parcelEntity.setWeight( parcelDto.getWeight() );
            parcelEntity.setRecipient( parcelDto.getRecipient() );
            parcelEntity.setSender( parcelDto.getSender() );
        }
        if ( trackingInformationDto != null ) {
            parcelEntity.setState( trackingInformationDto.getState() );
            List<HopArrival> list = trackingInformationDto.getVisitedHops();
            if ( list != null ) {
                parcelEntity.setVisitedHops( new ArrayList<HopArrival>( list ) );
            }
            List<HopArrival> list1 = trackingInformationDto.getFutureHops();
            if ( list1 != null ) {
                parcelEntity.setFutureHops( new ArrayList<HopArrival>( list1 ) );
            }
        }

        return parcelEntity;
    }

    @Override
    public ParcelEntity dtoToEntity(ParcelDto parcelDto) {
        if ( parcelDto == null ) {
            return null;
        }

        ParcelEntity parcelEntity = new ParcelEntity();

        parcelEntity.setWeight( parcelDto.getWeight() );
        parcelEntity.setRecipient( parcelDto.getRecipient() );
        parcelEntity.setSender( parcelDto.getSender() );

        return parcelEntity;
    }

    @Override
    public ParcelDto entityToDto(ParcelEntity parcel) {
        if ( parcel == null ) {
            return null;
        }

        ParcelDto parcelDto = new ParcelDto();

        parcelDto.setWeight( parcel.getWeight() );
        parcelDto.setRecipient( parcel.getRecipient() );
        parcelDto.setSender( parcel.getSender() );

        return parcelDto;
    }
}
