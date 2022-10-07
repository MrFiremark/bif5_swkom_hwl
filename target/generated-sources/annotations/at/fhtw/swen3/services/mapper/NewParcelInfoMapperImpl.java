package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entity.ParcelEntity;
import at.fhtw.swen3.services.dto.NewParcelInfoDto;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-10-07T12:21:49+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
public class NewParcelInfoMapperImpl implements NewParcelInfoMapper {

    @Override
    public ParcelEntity dtoToEntity(NewParcelInfoDto newParcelInfoDto) {
        if ( newParcelInfoDto == null ) {
            return null;
        }

        ParcelEntity parcelEntity = new ParcelEntity();

        return parcelEntity;
    }

    @Override
    public NewParcelInfoDto entityToDto(ParcelEntity parcel) {
        if ( parcel == null ) {
            return null;
        }

        NewParcelInfoDto newParcelInfoDto = new NewParcelInfoDto();

        return newParcelInfoDto;
    }
}
