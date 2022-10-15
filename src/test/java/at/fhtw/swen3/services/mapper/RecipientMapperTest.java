package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entity.RecipientEntity;
import at.fhtw.swen3.services.dto.Recipient;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

class RecipientMapperTest {

    private static final Logger log = LoggerFactory.getLogger(RecipientMapperTest.class);

    @Test
    void dtoToEntity() {
        log.info("Test Recipient dtoToEntity");
        final Recipient recipientDto = new Recipient();
        recipientDto.setName("Tux L. -Oves Azure");
        recipientDto.setStreet("Am Europlatz 3");
        recipientDto.setPostalCode("A-1120");
        recipientDto.setCity("Wien");
        recipientDto.setCountry("Austria");
        RecipientEntity recipientEntity = RecipientMapper.INSTANCE.dtoToEntity(recipientDto);
        assertEquals(recipientEntity.getName(), recipientDto.getName());
        assertEquals(recipientEntity.getStreet(), recipientDto.getStreet());
        assertEquals(recipientEntity.getPostalCode(), recipientDto.getPostalCode());
        assertEquals(recipientEntity.getCity(), recipientDto.getCity());
        assertEquals(recipientEntity.getCountry(), recipientDto.getCountry());
    }

    @Test
    void entityToDto() {
        log.info("Test Recipient entityToDto");
        final RecipientEntity recipientEntity = new RecipientEntity("Tux L. -Oves Azure", "Am Europlatz 3", "A-1120", "Wien", "Austria");
        Recipient recipientDto = RecipientMapper.INSTANCE.entityToDto(recipientEntity);
        assertEquals(recipientEntity.getName(), recipientDto.getName());
        assertEquals(recipientEntity.getStreet(), recipientDto.getStreet());
        assertEquals(recipientEntity.getPostalCode(), recipientDto.getPostalCode());
        assertEquals(recipientEntity.getCity(), recipientDto.getCity());
        assertEquals(recipientEntity.getCountry(), recipientDto.getCountry());
    }
}