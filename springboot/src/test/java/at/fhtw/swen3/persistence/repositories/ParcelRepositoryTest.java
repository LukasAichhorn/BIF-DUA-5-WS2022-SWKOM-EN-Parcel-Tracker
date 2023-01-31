package at.fhtw.swen3.persistence.repositories;

import at.fhtw.swen3.openapitools.OpenApiGeneratorApplication;
import at.fhtw.swen3.persistence.entities.ParcelEntity;
import at.fhtw.swen3.persistence.entities.RecipientEntity;
import at.fhtw.swen3.services.dto.HopArrival;
import at.fhtw.swen3.services.dto.Parcel;
import at.fhtw.swen3.services.dto.Recipient;
import at.fhtw.swen3.services.dto.TrackingInformation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.Context;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(classes = OpenApiGeneratorApplication.class)
@TestPropertySource("classpath:application-test.properties")

class ParcelRepositoryTest {
    @Autowired
    ParcelRepository parcelRepository;
    @Autowired
    RecipientRepository recipientRepository;
    ParcelEntity testParcel;
    RecipientEntity testRecipient;


    @BeforeEach
    void setup (){
        testRecipient = new RecipientEntity();
        testRecipient.setCity("Vienna");
        testRecipient.setCountry("Austria");
        testRecipient.setName("Heinz");
        testRecipient.setStreet("Burggasse 34");
        testRecipient.setPostalCode("A-1070");

        testParcel = new ParcelEntity();
        testParcel.setTrackingId("REVIEW001");
        testParcel.setWeight(1.0F);
        testParcel.setState(ParcelEntity.StateEnum.INTRUCKDELIVERY);
        testParcel.setRecipient(testRecipient);
        testParcel.setSender(testRecipient);

    }

    @Test
    void h2_parcelRepository_Insert() {
        recipientRepository.save(testRecipient);
        parcelRepository.save(testParcel);
        assertTrue(parcelRepository.findByTrackingId("REVIEW001").isPresent());
    }

}