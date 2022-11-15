package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.RecipientEntity;
import at.fhtw.swen3.services.dto.Recipient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RecipientMapperTest {
    Recipient recipientDto;
    RecipientEntity recipientEntity;

    @BeforeEach
    void setUp() {
        recipientDto = new Recipient();
        recipientDto.setPostalCode("A-1030");
        recipientDto.setStreet("Baumgasse");
        recipientDto.setCountry("Austria");
        recipientDto.setName("Heinrich");
        recipientDto.setCity("Wien");

        recipientEntity = new RecipientEntity();
        recipientEntity.setCity("Vienna");
        recipientEntity.setName("Ingolf");
        recipientEntity.setPostalCode("A-1080");
        recipientEntity.setStreet("Albertgasse");
        recipientEntity.setCountry("Österreich");
    }

    @Test
    void recipientEntitiyToRecipientDto() {
        Recipient testRecipientDto = RecipientMapper.INSTANCE.recipientEntitiyToRecipientDto(recipientEntity);

        assertEquals(testRecipientDto.getPostalCode(), recipientEntity.getPostalCode());
        assertEquals(testRecipientDto.getStreet(), recipientEntity.getStreet());
        assertEquals(testRecipientDto.getName(), recipientEntity.getName());
        assertEquals(testRecipientDto.getCountry(), recipientEntity.getCountry());
        assertEquals(testRecipientDto.getCity(), recipientEntity.getCity());
    }

    @Test
    void recipientDtoToRecipientEntity() {
        RecipientEntity testRecipientEntity = RecipientMapper.INSTANCE.recipientDtoToRecipientEntity(recipientDto);

        assertEquals(testRecipientEntity.getPostalCode(), recipientDto.getPostalCode());
        assertEquals(testRecipientEntity.getStreet(), recipientDto.getStreet());
        assertEquals(testRecipientEntity.getName(), recipientDto.getName());
        assertEquals(testRecipientEntity.getCountry(), recipientDto.getCountry());
        assertEquals(testRecipientEntity.getCity(), recipientDto.getCity());
    }
}