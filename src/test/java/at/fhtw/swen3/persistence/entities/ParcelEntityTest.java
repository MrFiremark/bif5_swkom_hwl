package at.fhtw.swen3.persistence.entities;

import at.fhtw.swen3.persistence.enums.StateEnum;
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
        RecipientEntity recipientEntity = RecipientEntity.builder()
                .name("Anton")
                .street("Landstraße 27")
                .postalCode("A-2420")
                .city("Vienna")
                .country("Austria")
                .build();

        RecipientEntity senderEntity = RecipientEntity.builder()
                .name("Max")
                .street("Europlatz 97")
                .postalCode("A-3540")
                .city("Vienna")
                .country("Austria")
                .build();

        ParcelEntity parcelEntity = ParcelEntity.builder()
                .trackingId("A12007895")
                .weight(1.0f)
                .recipient(recipientEntity)
                .state(StateEnum.PICKUP)
                .sender(senderEntity)
                .visitedHops(new ArrayList<HopArrivalEntity>())
                .futureHops(new ArrayList<HopArrivalEntity>())
                .build();

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Set<ConstraintViolation<ParcelEntity>> violations = validator.validate(parcelEntity);
        for (ConstraintViolation<ParcelEntity> violation : violations)
            fail("Validation should fail!");
    }
}