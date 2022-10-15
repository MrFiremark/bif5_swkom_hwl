package at.fhtw.swen3.persistence.entity;

import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.time.OffsetDateTime;
import java.util.Set;

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

    @Test
    public void validationTest_NotOk() {
        final RecipientEntity entity = RecipientEntity.builder()
                .name("Markus")
                .street("Landstraße 27")
                .postalCode("B-2420")
                .city("Vienna")
                .country("Austria")
                .build();
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Set<ConstraintViolation<RecipientEntity>> violations = validator.validate(entity);
        for (ConstraintViolation<RecipientEntity> violation : violations)
            return;
        fail("Validation should fail!");
    }

    @Test
    public void validationTest_Ok() {
        final RecipientEntity entity = RecipientEntity.builder()
                .name("Markus")
                .street("Landstraße 27")
                .postalCode("A-1200")
                .city("Vienna")
                .country("Austria")
                .build();
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Set<ConstraintViolation<RecipientEntity>> violations = validator.validate(entity);
        for (ConstraintViolation<RecipientEntity> violation : violations)
            fail("Validation should fail!");
    }
}