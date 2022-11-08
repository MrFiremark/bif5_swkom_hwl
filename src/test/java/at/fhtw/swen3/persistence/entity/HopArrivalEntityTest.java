package at.fhtw.swen3.persistence.entity;

import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.time.OffsetDateTime;
import java.util.Set;

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

    @Test
    public void validationTest_NotOk() {
        final HopArrivalEntity entity = HopArrivalEntity.builder()
                .code("ABC5")
                .description("Warehouse 12-27")
                .dateTime(OffsetDateTime.now())
                .build();
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Set<ConstraintViolation<HopArrivalEntity>> violations = validator.validate(entity);
        for (ConstraintViolation<HopArrivalEntity> violation : violations)
            return;
        fail("Validation should fail!");
    }

    @Test
    public void validationTest_Ok() {
        final HopArrivalEntity entity = HopArrivalEntity.builder()
                .code("ABCD12")
                .description("Warehouse 12-27")
                .dateTime(OffsetDateTime.now())
                .build();
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Set<ConstraintViolation<HopArrivalEntity>> violations = validator.validate(entity);
        for (ConstraintViolation<HopArrivalEntity> violation : violations)
            fail("Validation should fail!");
    }
}