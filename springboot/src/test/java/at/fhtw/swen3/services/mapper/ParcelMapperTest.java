package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.ParcelEntity;
import at.fhtw.swen3.services.dto.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;

import static org.junit.jupiter.api.Assertions.*;

class ParcelMapperTest {

    private Parcel p;
    private TrackingInformation ti;
    private NewParcelInfo npi;
    private ParcelEntity pe;


    @BeforeEach
    void setUp() {
        Recipient testRecipient = new Recipient();
        testRecipient.setCity("Vienna");
        testRecipient.setCountry("Austria");
        testRecipient.setName("Heinz");
        testRecipient.setStreet("Burggasse");
        testRecipient.setPostalCode("A-1070");

        HopArrival testHop = new HopArrival();
        testHop.setCode("1234");
        testHop.setDateTime(OffsetDateTime.of(2022, 11, 14, 20, 41, 0, 0, ZoneOffset.UTC));
        testHop.setDescription("TestHop");
        p = new Parcel();
        p.setWeight(1.0F);
        p.setRecipient(testRecipient);
        p.setSender(testRecipient);

        ti = new TrackingInformation();
        ti.setState(TrackingInformation.StateEnum.INTRANSPORT);
        ti.addFutureHopsItem(testHop);
        ti.addVisitedHopsItem(testHop);

        npi = new NewParcelInfo();
        npi.setTrackingId("TestTrackingId");

        pe = ParcelEntity
                .builder()
                .state(ParcelEntity.StateEnum.DELIVERED)
                .weight(1.0F)
                .trackingId("TestTrackingId")
                .recipient(RecipientMapper.INSTANCE.recipientDtoToRecipientEntity(testRecipient))
                .sender(RecipientMapper.INSTANCE.recipientDtoToRecipientEntity(testRecipient))
                .visitedHop(HopArrivalMapper.INSTANCE.hopArrivalDtoToHopArrivalEntity(testHop))
                .futureHop(HopArrivalMapper.INSTANCE.hopArrivalDtoToHopArrivalEntity(testHop))
                .build();
    }

    @Test
    void fromParcelDtosToParcelEntity() {
        ParcelEntity testParcelEntity = ParcelMapper.INSTANCE.fromParcelDtosToParcelEntity(p, npi, ti);

        assertEquals(testParcelEntity.getWeight(), p.getWeight());
        assertEquals(testParcelEntity.getTrackingId(), npi.getTrackingId());
        assertEquals(testParcelEntity.getRecipient(), RecipientMapper.INSTANCE.recipientDtoToRecipientEntity(p.getRecipient()));
        assertEquals(testParcelEntity.getSender(), RecipientMapper.INSTANCE.recipientDtoToRecipientEntity(p.getSender()));
        assertEquals(testParcelEntity.getFutureHops().get(0), HopArrivalMapper.INSTANCE.hopArrivalDtoToHopArrivalEntity(ti.getFutureHops().get(0)));
        assertEquals(testParcelEntity.getVisitedHops().get(0), HopArrivalMapper.INSTANCE.hopArrivalDtoToHopArrivalEntity(ti.getVisitedHops().get(0)));
        assertEquals(testParcelEntity.getState().getValue(), ti.getState().getValue());

    }

    @Test
    void fromParcelEntityToParcel() {
        Parcel testParcel = ParcelMapper.INSTANCE.fromParcelEntityToParcel(pe);

        assertEquals(testParcel.getWeight(), pe.getWeight());
        assertEquals(testParcel.getRecipient(), RecipientMapper.INSTANCE.recipientEntitiyToRecipientDto(pe.getRecipient()));
        assertEquals(testParcel.getSender(), RecipientMapper.INSTANCE.recipientEntitiyToRecipientDto(pe.getSender()));



    }

    @Test
    void fromParcelEntityToNewParcelInfo() {
        NewParcelInfo testNpi = ParcelMapper.INSTANCE.fromParcelEntityToNewParcelInfo(pe);

        assertEquals(testNpi.getTrackingId(), pe.getTrackingId());
    }

    @Test
    void fromParcelEntityToTrackingInformation() {
        TrackingInformation testTi = ParcelMapper.INSTANCE.fromParcelEntityToTrackingInformation(pe);

        assertEquals(testTi.getState().getValue(), pe.getState().getValue());
        assertEquals(testTi.getVisitedHops().get(0), HopArrivalMapper.INSTANCE.hopArrivalEntitiyToHopArrivalDto(pe.getVisitedHops().get(0)));
        assertEquals(testTi.getFutureHops().get(0), HopArrivalMapper.INSTANCE.hopArrivalEntitiyToHopArrivalDto(pe.getFutureHops().get(0)));
    }
}