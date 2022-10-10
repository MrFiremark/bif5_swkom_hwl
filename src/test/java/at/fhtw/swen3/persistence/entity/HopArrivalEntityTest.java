package at.fhtw.swen3.persistence.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HopArrivalEntityTest {

    @Test
    void checkFalseCode()
    {
        HopArrivalEntity hopArrivalEntity = HopArrivalEntity.builder()
                .code("ABCDF")
                .build();
        assertFalse(hopArrivalEntity.checkCode(), "This is false!");
    }

    @Test
    void checkTrueCode()
    {
        HopArrivalEntity hopArrivalEntity = HopArrivalEntity.builder()
                .code("ABCD12")
                .build();
        assertTrue(hopArrivalEntity.checkCode(), "This is true!");
    }

    @Test
    void checkFalseDescription()
    {
        HopArrivalEntity hopArrivalEntity = HopArrivalEntity.builder()
                .description("Warehouse#12!")
                .build();
        assertFalse(hopArrivalEntity.checkDescription(), "This is false!");
    }

    @Test
    void checkTrueDescription()
    {
        HopArrivalEntity hopArrivalEntity = HopArrivalEntity.builder()
                .description("Warehouse 12-27")
                .build();
        assertTrue(hopArrivalEntity.checkDescription(), "This is true!");
    }
}