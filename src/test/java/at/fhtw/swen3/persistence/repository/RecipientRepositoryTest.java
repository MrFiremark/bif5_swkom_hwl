package at.fhtw.swen3.persistence.repository;

import at.fhtw.swen3.persistence.entity.RecipientEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RecipientRepositoryTest {

    @Autowired
    private RecipientRepository recipientRepository;

    @Test
    public void testSaveNewRecipient() {

        RecipientEntity recipient = RecipientEntity.builder()
                .name("Markus")
                .street("Landstraße 27")
                .postalCode("B-2420")
                .city("Vienna")
                .country("Austria")
                .build();

        recipientRepository.save(recipient);

        assertEquals(recipientRepository.count(), 1);

        recipientRepository.findByName("Markus");
    }
}
