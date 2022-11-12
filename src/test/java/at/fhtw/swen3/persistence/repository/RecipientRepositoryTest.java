package at.fhtw.swen3.persistence.repository;

import at.fhtw.swen3.persistence.entities.RecipientEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class RecipientRepositoryTest {

    @Autowired
    RecipientRepository recipientRepository;

    public RecipientEntity recipient = RecipientEntity.builder()
            .name("Markus Test")
            .street("Landstraße 27")
            .postalCode("B-2420")
            .city("Vienna")
            .country("Austria")
            .build();

    @Test
    public void testSaveNewRecipient() {
        recipientRepository.save(recipient);
        assertEquals(recipientRepository.count(), 1);
    }

    @Test
    public void testGetRecipient(){
        assertEquals(recipientRepository.findByName("Markus Test").get(0).getName(), recipient.getName());
    }

    @Test
    public void testUpdateRecipient(){
        recipient.setCity("Graz");
        recipientRepository.save(recipient);

        assertEquals(recipientRepository.count(),1);
    }

    @Test
    public void testDeleteRecipient(){
        recipientRepository.delete(recipient);
        assertEquals(recipientRepository.count(), 0);
    }
}
