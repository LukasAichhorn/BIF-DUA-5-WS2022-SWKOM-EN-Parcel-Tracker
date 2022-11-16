package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.GeoCoordinateEntity;
import at.fhtw.swen3.persistence.entities.HopEntity;
import at.fhtw.swen3.services.dto.GeoCoordinate;
import at.fhtw.swen3.services.dto.Hop;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HopMapperTest {
    Hop hopDto;
    HopEntity hopEntity;

    @BeforeEach
    void setUp() {
        GeoCoordinate testGeoCoordinateDto = new GeoCoordinate();
        testGeoCoordinateDto.setLon(1.5);
        testGeoCoordinateDto.setLat(1.5);

        GeoCoordinateEntity testGeoCoordinateEntity = new GeoCoordinateEntity();
        testGeoCoordinateEntity.setLon(2.5);
        testGeoCoordinateEntity.setLat(2.5);

        hopDto = new Hop();
        hopDto.setCode("1234");
        hopDto.setHopType("Store");
        hopDto.setDescription("TestHop");
        hopDto.setLocationName("TestHopName");
        hopDto.setProcessingDelayMins(1);
        hopDto.setLocationCoordinates(testGeoCoordinateDto);

        hopEntity = HopEntity.builder()
                .code("4321")
                .hopType("House")
                .description("TestHopEntity")
                .locationName("TestHopEntityName")
                .processingDelayMins(2)
                .locationCoordinates(testGeoCoordinateEntity)
                .build();

    }

    @Test
    void hopEntitiyToHopDto() {
        Hop testHopDto = HopMapper.INSTANCE.hopEntitiyToHopDto(hopEntity);

        assertEquals(testHopDto.getCode(), hopEntity.getCode());
        assertEquals(testHopDto.getDescription(), hopEntity.getDescription());
        assertEquals(testHopDto.getHopType(), hopEntity.getHopType());
        assertEquals(testHopDto.getLocationCoordinates(), GeoCoordinateMapper.INSTANCE.geoCoordinateEntitiyToGeoCoordinateDto(hopEntity.getLocationCoordinates()));
        assertEquals(testHopDto.getLocationName(), hopEntity.getLocationName());
        assertEquals(testHopDto.getProcessingDelayMins(), hopEntity.getProcessingDelayMins());
    }

    @Test
    void hopDtoToHopEntity() {
        HopEntity testHopEntity = HopMapper.INSTANCE.hopDtoToHopEntity(hopDto);

        assertEquals(testHopEntity.getCode(), hopDto.getCode());
        assertEquals(testHopEntity.getDescription(), hopDto.getDescription());
        assertEquals(testHopEntity.getHopType(), hopDto.getHopType());
        assertEquals(testHopEntity.getLocationCoordinates(), GeoCoordinateMapper.INSTANCE.geoCoordinateDtoToGeoCoordinateEntity(hopDto.getLocationCoordinates()));
        assertEquals(testHopEntity.getLocationName(), hopDto.getLocationName());
        assertEquals(testHopEntity.getProcessingDelayMins(), hopDto.getProcessingDelayMins());
    }
}