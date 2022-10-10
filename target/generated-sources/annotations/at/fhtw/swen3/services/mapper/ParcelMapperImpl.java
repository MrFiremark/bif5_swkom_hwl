package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entity.ParcelEntity;
import at.fhtw.swen3.services.dto.HopArrival;
import at.fhtw.swen3.services.dto.NewParcelInfo;
import at.fhtw.swen3.services.dto.Parcel;
import at.fhtw.swen3.services.dto.TrackingInformation;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-10-10T14:11:53+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
public class ParcelMapperImpl implements ParcelMapper {

    @Override
    public ParcelEntity dtoToEntity(NewParcelInfo newParcelInfo, Parcel parcel, TrackingInformation trackingInformation) {
        if ( newParcelInfo == null && parcel == null && trackingInformation == null ) {
            return null;
        }

        ParcelEntity parcelEntity = new ParcelEntity();

        if ( newParcelInfo != null ) {
            parcelEntity.setTrackingId( newParcelInfo.getTrackingId() );
        }
        if ( parcel != null ) {
            parcelEntity.setWeight( parcel.getWeight() );
            parcelEntity.setRecipient( parcel.getRecipient() );
            parcelEntity.setSender( parcel.getSender() );
        }
        if ( trackingInformation != null ) {
            parcelEntity.setState( trackingInformation.getState() );
            List<HopArrival> list = trackingInformation.getVisitedHops();
            if ( list != null ) {
                parcelEntity.setVisitedHops( new ArrayList<HopArrival>( list ) );
            }
            List<HopArrival> list1 = trackingInformation.getFutureHops();
            if ( list1 != null ) {
                parcelEntity.setFutureHops( new ArrayList<HopArrival>( list1 ) );
            }
        }

        return parcelEntity;
    }
}
