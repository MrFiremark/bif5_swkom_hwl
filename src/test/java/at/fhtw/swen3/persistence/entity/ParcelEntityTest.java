package at.fhtw.swen3.persistence.entity;

import org.junit.jupiter.api.Test;

import javax.validation.constraints.AssertTrue;

import static org.junit.jupiter.api.Assertions.*;

class ParcelEntityTest {

    @Test
    void checkFalseWeight() {
        ParcelEntity entity = ParcelEntity.builder()
                .weight((float)(-1.1))
                .build();
        assertFalse(entity.checkWeight(), "This is false!");
    }

    @Test
    void CheckTrueWeight(){
        ParcelEntity entity = ParcelEntity.builder()
                .weight((float)(1))
                .build();
        assertTrue(entity.checkWeight(), "This is true!");
    }

    @Test
    void checkFalseTrackingId() {
        ParcelEntity entity = ParcelEntity.builder()
                .trackingId("B-1220")
                .build();
        assertFalse(entity.checkTrackingId(), "This is false!");
    }

    @Test void checkTrueTrackingId() {
        ParcelEntity entity = ParcelEntity.builder()
                .trackingId("A12007895")
                .build();
        assertTrue(entity.checkTrackingId(), "This is true!");
    }
}