package at.fhtw.swen3.persistence.entity;

import at.fhtw.swen3.openapitools.OpenApiGeneratorApplication;
import at.fhtw.swen3.persistence.enums.StateEnum;
import at.fhtw.swen3.services.dto.Hop;
import at.fhtw.swen3.services.dto.HopArrival;
import at.fhtw.swen3.services.dto.Recipient;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.AssertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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

    @Test
    void checkTrueTrackingId() {
        ParcelEntity entity = ParcelEntity.builder()
                .trackingId("A12007895")
                .build();
        assertTrue(entity.checkTrackingId(), "This is true!");
    }
    @Test
    void checkValidation_NotOk() {
        ParcelEntity entity = ParcelEntity.builder()
                .trackingId("A12007895")
                .weight(-1.0f)
                .recipient(new RecipientEntity())
                .sender(new RecipientEntity())
                .visitedHops(new ArrayList<HopArrivalEntity>())
                .futureHops(new ArrayList<HopArrivalEntity>())
                .build();
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Set<ConstraintViolation<ParcelEntity>> violations = validator.validate(entity);
        for (ConstraintViolation<ParcelEntity> violation : violations)
            return;
        fail("Validation should fail!");
    }

    @Test
    void checkValidation_Ok() {
        ParcelEntity entity = ParcelEntity.builder()
                .trackingId("A12007895")
                .weight(1.0f)
                .recipient(new RecipientEntity())
                .sender(new RecipientEntity())
                .visitedHops(new ArrayList<HopArrivalEntity>())
                .futureHops(new ArrayList<HopArrivalEntity>())
                .build();
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Set<ConstraintViolation<ParcelEntity>> violations = validator.validate(entity);
        for (ConstraintViolation<ParcelEntity> violation : violations)
            fail("Validation should fail!");
    }
}