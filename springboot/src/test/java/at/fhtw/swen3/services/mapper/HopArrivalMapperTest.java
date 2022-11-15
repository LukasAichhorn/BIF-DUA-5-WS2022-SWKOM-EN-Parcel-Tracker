package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.HopArrivalEntity;
import at.fhtw.swen3.services.dto.HopArrival;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;

import static org.junit.jupiter.api.Assertions.*;


class HopArrivalMapperTest {
    private HopArrival hopArrival;
    private HopArrivalEntity hopArrivalEntity;


    @BeforeEach
    void setUp() {
        hopArrival = new HopArrival();
        hopArrival.setCode("1234");
        hopArrival.setDateTime(OffsetDateTime.of(2022, 11, 14, 20, 41, 0, 0, ZoneOffset.UTC));
        hopArrival.setDescription("TestHop");

        hopArrivalEntity = new HopArrivalEntity();
        hopArrival.setCode("4321");
        hopArrival.setDateTime(OffsetDateTime.of(2021, 10, 13, 21, 45, 0, 0, ZoneOffset.UTC));
        hopArrival.setDescription("TestHopEntity");
    }

    @Test
    void hopArrivalEntitiyToHopArrivalDto() {
        HopArrival testHopDto = HopArrivalMapper.INSTANCE.hopArrivalEntitiyToHopArrivalDto(hopArrivalEntity);

        assertEquals(testHopDto.getCode(), hopArrivalEntity.getCode());
        assertEquals(testHopDto.getDescription(), hopArrivalEntity.getDescription());
        assertEquals(testHopDto.getDateTime(), hopArrivalEntity.getDateTime());

    }

    @Test
    void hopArrivalDtoToHopArrivalEntity() {
        HopArrivalEntity testHopEntity = HopArrivalMapper.INSTANCE.hopArrivalDtoToHopArrivalEntity(hopArrival);

        assertEquals(testHopEntity.getCode(), hopArrival.getCode());
        assertEquals(testHopEntity.getDescription(), hopArrival.getDescription());
        assertEquals(testHopEntity.getDateTime(), hopArrival.getDateTime());
    }
}