package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entity.HopArrivalEntity;
import at.fhtw.swen3.persistence.entity.HopArrivalEntity.HopArrivalEntityBuilder;
import at.fhtw.swen3.persistence.entity.ParcelEntity;
import at.fhtw.swen3.persistence.entity.ParcelEntity.ParcelEntityBuilder;
import at.fhtw.swen3.persistence.entity.RecipientEntity;
import at.fhtw.swen3.persistence.entity.RecipientEntity.RecipientEntityBuilder;
import at.fhtw.swen3.services.dto.HopArrival;
import at.fhtw.swen3.services.dto.NewParcelInfo;
import at.fhtw.swen3.services.dto.Parcel;
import at.fhtw.swen3.services.dto.Recipient;
import at.fhtw.swen3.services.dto.TrackingInformation;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-10-15T17:05:42+0200",
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
            parcelEntity.recipient( recipientToRecipientEntity( parcel.getRecipient() ) );
            parcelEntity.sender( recipientToRecipientEntity( parcel.getSender() ) );
        }
        if ( trackingInformation != null ) {
            parcelEntity.state( trackingInformation.getState() );
            parcelEntity.visitedHops( hopArrivalListToHopArrivalEntityList( trackingInformation.getVisitedHops() ) );
            parcelEntity.futureHops( hopArrivalListToHopArrivalEntityList( trackingInformation.getFutureHops() ) );
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

    protected RecipientEntity recipientToRecipientEntity(Recipient recipient) {
        if ( recipient == null ) {
            return null;
        }

        RecipientEntityBuilder recipientEntity = RecipientEntity.builder();

        recipientEntity.name( recipient.getName() );
        recipientEntity.street( recipient.getStreet() );
        recipientEntity.postalCode( recipient.getPostalCode() );
        recipientEntity.city( recipient.getCity() );
        recipientEntity.country( recipient.getCountry() );

        return recipientEntity.build();
    }

    protected HopArrivalEntity hopArrivalToHopArrivalEntity(HopArrival hopArrival) {
        if ( hopArrival == null ) {
            return null;
        }

        HopArrivalEntityBuilder hopArrivalEntity = HopArrivalEntity.builder();

        hopArrivalEntity.code( hopArrival.getCode() );
        hopArrivalEntity.description( hopArrival.getDescription() );
        hopArrivalEntity.dateTime( hopArrival.getDateTime() );

        return hopArrivalEntity.build();
    }

    protected List<HopArrivalEntity> hopArrivalListToHopArrivalEntityList(List<HopArrival> list) {
        if ( list == null ) {
            return null;
        }

        List<HopArrivalEntity> list1 = new ArrayList<HopArrivalEntity>( list.size() );
        for ( HopArrival hopArrival : list ) {
            list1.add( hopArrivalToHopArrivalEntity( hopArrival ) );
        }

        return list1;
    }
}
