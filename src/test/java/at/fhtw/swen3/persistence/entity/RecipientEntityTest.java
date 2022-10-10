package at.fhtw.swen3.persistence.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RecipientEntityTest {
    @Test
    void checkFalseStreet()
    {
        RecipientEntity recipientEntity = RecipientEntity.builder()
                .street("Land!Stra0e!")
                .build();
        assertFalse(recipientEntity.checkStreet(), "This is false!");
    }

    @Test
    void checkTrueStreet()
    {
        RecipientEntity recipientEntity = RecipientEntity.builder()
                .street("Landstrasse 70")
                .build();
        assertTrue(recipientEntity.checkStreet(), "This is true!");
    }

    @Test
    void checkFalsePostalCode()
    {
        RecipientEntity recipientEntity = RecipientEntity.builder()
                .postalCode("B-5622")
                .build();
        assertFalse(recipientEntity.checkPostalCode(), "This is false!");
    }

    @Test
    void checkTruePostalCode()
    {
        RecipientEntity recipientEntity = RecipientEntity.builder()
                .postalCode("A-1200")
                .build();
        assertTrue(recipientEntity.checkPostalCode(), "This is true!");
    }

    @Test
    void checkFalseCity()
    {
        RecipientEntity recipientEntity = RecipientEntity.builder()
                .city("Berlin!")
                .build();
        assertFalse(recipientEntity.checkCity(), "This is false!");
    }

    @Test
    void checkTrueCity()
    {
        RecipientEntity recipientEntity = RecipientEntity.builder()
                .city("Vienna")
                .build();
        assertTrue(recipientEntity.checkCity(), "This is true!");
    }
}