package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entity.ParcelEntity;
import at.fhtw.swen3.persistence.entity.ParcelEntity.ParcelEntityBuilder;
import at.fhtw.swen3.services.dto.HopArrival;
import at.fhtw.swen3.services.dto.NewParcelInfo;
import at.fhtw.swen3.services.dto.Parcel;
import at.fhtw.swen3.services.dto.TrackingInformation;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-10-10T20:53:35+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
public class ParcelMapperImpl implements ParcelMapper {

    @Override
    public ParcelEntity dtoToEntity(NewParcelInfo newParcelInfo, Parcel parcel, TrackingInformation trackingInformation) {
        if ( newParcelInfo == null && parcel == null && trackingInformation == null ) {
            return null;
        }

        ParcelEntityBuilder parcelEntity = ParcelEntity.builder();

        if ( newParcelInfo != null ) {
            parcelEntity.trackingId( newParcelInfo.getTrackingId() );
        }
        if ( parcel != null ) {
            parcelEntity.weight( parcel.getWeight() );
            parcelEntity.recipient( parcel.getRecipient() );
            parcelEntity.sender( parcel.getSender() );
        }
        if ( trackingInformation != null ) {
            parcelEntity.state( trackingInformation.getState() );
            List<HopArrival> list = trackingInformation.getVisitedHops();
            if ( list != null ) {
                parcelEntity.visitedHops( new ArrayList<HopArrival>( list ) );
            }
            List<HopArrival> list1 = trackingInformation.getFutureHops();
            if ( list1 != null ) {
                parcelEntity.futureHops( new ArrayList<HopArrival>( list1 ) );
            }
        }

        return parcelEntity.build();
    }

    @Override
    public NewParcelInfo entityToNewParcelInfoDto(Parcel parcel) {
        if ( parcel == null ) {
            return null;
        }

        NewParcelInfo newParcelInfo = new NewParcelInfo();

        return newParcelInfo;
    }

    @Override
    public Parcel entityToParcelDto(Parcel parcel) {
        if ( parcel == null ) {
            return null;
        }

        Parcel parcel1 = new Parcel();

        parcel1.setWeight( parcel.getWeight() );
        parcel1.setRecipient( parcel.getRecipient() );
        parcel1.setSender( parcel.getSender() );

        return parcel1;
    }

    @Override
    public TrackingInformation entityToTrackingInformationDto(Parcel parcel) {
        if ( parcel == null ) {
            return null;
        }

        TrackingInformation trackingInformation = new TrackingInformation();

        return trackingInformation;
    }
}
