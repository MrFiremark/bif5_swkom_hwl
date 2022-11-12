package at.fhtw.swen3.persistence.repository;

import at.fhtw.swen3.persistence.entities.HopArrivalEntity;
import at.fhtw.swen3.persistence.entities.ParcelEntity;
import at.fhtw.swen3.persistence.entities.RecipientEntity;
import at.fhtw.swen3.persistence.enums.StateEnum;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ParcelRepositoryTest {

    @Autowired
    private ParcelRepository parcelRepository;

    @Autowired
    private RecipientRepository recipientRepository;

    @Test
    void checkParcelSave() {
        RecipientEntity recipientEntity = RecipientEntity.builder()
                .name("Markus")
                .street("Landstraße 27")
                .postalCode("A-2420")
                .city("Vienna")
                .country("Austria")
                .build();

        RecipientEntity senderEntity = RecipientEntity.builder()
                .name("Holzer")
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

        parcelRepository.save(parcelEntity);
        System.out.println(recipientRepository.count());
    }

    @Test
    void getRecipient(){
        List<ParcelEntity> parcelEntityList = parcelRepository.findAll();
        System.out.println(parcelEntityList.get(0).getRecipient().getName());
    }
}