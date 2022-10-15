package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entity.HopArrivalEntity;
import at.fhtw.swen3.services.dto.HopArrival;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.OffsetDateTime;

import static org.junit.jupiter.api.Assertions.*;

class HopArrivalMapperTest {

    private static final Logger log = LoggerFactory.getLogger(HopArrivalMapperTest.class);

    @Test
    void dtoToEntity() {
        log.info("Test HopArrival dtoToEntity()");
        final HopArrival hopArrivalDto = new HopArrival();
        hopArrivalDto.setCode("ABCD12");
        hopArrivalDto.setDescription("Warehouse 12-14");
        hopArrivalDto.setDateTime(OffsetDateTime.now());

        HopArrivalEntity hopArrivalEntity = HopArrivalMapper.INSTANCE.dtoToEntity(hopArrivalDto);
        assertEquals(hopArrivalEntity.getCode(), hopArrivalDto.getCode());
        assertEquals(hopArrivalEntity.getDescription(), hopArrivalDto.getDescription());
        assertEquals(hopArrivalEntity.getDateTime(), hopArrivalDto.getDateTime());
    }

    @Test
    void entityToDto() {
        log.info("Test HopArrival entityToDto()");
        final HopArrivalEntity hopArrivalEntity = new HopArrivalEntity();
        hopArrivalEntity.setCode("ABCD12");
        hopArrivalEntity.setDescription("Warehouse 12-14");
        hopArrivalEntity.setDateTime(OffsetDateTime.now());

        HopArrival hopArrivalDto = HopArrivalMapper.INSTANCE.entityToDto(hopArrivalEntity);
        assertEquals(hopArrivalEntity.getCode(), hopArrivalDto.getCode());
        assertEquals(hopArrivalEntity.getDescription(), hopArrivalDto.getDescription());
        assertEquals(hopArrivalEntity.getDateTime(), hopArrivalDto.getDateTime());
    }
}