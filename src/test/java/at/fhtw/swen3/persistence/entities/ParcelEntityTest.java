package at.fhtw.swen3.persistence.entities;

import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import java.util.ArrayList;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ParcelEntityTest {
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