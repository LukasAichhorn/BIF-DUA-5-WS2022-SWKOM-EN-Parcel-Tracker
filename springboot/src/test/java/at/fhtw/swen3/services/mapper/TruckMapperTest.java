package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.GeoCoordinateEntity;
import at.fhtw.swen3.persistence.entities.TransferwarehouseEntity;
import at.fhtw.swen3.persistence.entities.TruckEntity;
import at.fhtw.swen3.services.dto.GeoCoordinate;
import at.fhtw.swen3.services.dto.Transferwarehouse;
import at.fhtw.swen3.services.dto.Truck;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TruckMapperTest {

    Truck truckDto;
    TruckEntity truckEntity;

    @BeforeEach
    void setUp() {
        GeoCoordinate testGeoCoordinateDto = new GeoCoordinate();
        testGeoCoordinateDto.setLon(1.5);
        testGeoCoordinateDto.setLat(1.5);

        GeoCoordinateEntity testGeoCoordinateEntity = new GeoCoordinateEntity();
        testGeoCoordinateEntity.setLon(2.5);
        testGeoCoordinateEntity.setLat(2.5);

        truckDto = new Truck();
        truckDto.setCode("1234");
        truckDto.setHopType("Store");
        truckDto.setDescription("TestHop");
        truckDto.setLocationName("TestHopName");
        truckDto.setProcessingDelayMins(1);
        truckDto.setLocationCoordinates(testGeoCoordinateDto);
        truckDto.setRegionGeoJson("{name:'testTruckDto'}");
        truckDto.setNumberPlate("W-12345K");

        truckEntity = TruckEntity.builder()
                .code("4321")
                .hopType("House")
                .description("TestHopEntity")
                .locationName("TestHopEntityName")
                .processingDelayMins(2)
                .locationCoordinates(testGeoCoordinateEntity)
                .numberPlate("W-54312K")
                .regionGeoJson("{name:'testTruckEntity'}")
                .build();
    }

    @Test
    void truckEntitiyToTruckDto() {
        Truck testTruckDto = TruckMapper.INSTANCE.truckEntitiyToTruckDto(truckEntity);

        assertEquals(testTruckDto.getCode(), truckEntity.getCode());
        assertEquals(testTruckDto.getDescription(), truckEntity.getDescription());
        assertEquals(testTruckDto.getHopType(), truckEntity.getHopType());
        assertEquals(testTruckDto.getLocationCoordinates(), GeoCoordinateMapper.INSTANCE.geoCoordinateEntitiyToGeoCoordinateDto(truckEntity.getLocationCoordinates()));
        assertEquals(testTruckDto.getLocationName(), truckEntity.getLocationName());
        assertEquals(testTruckDto.getProcessingDelayMins(), truckEntity.getProcessingDelayMins());
        assertEquals(testTruckDto.getNumberPlate(), truckEntity.getNumberPlate());
        assertEquals(testTruckDto.getRegionGeoJson(), truckEntity.getRegionGeoJson());
    }

    @Test
    void truckDtoToTruckEntity() {
        TruckEntity testTruckEntity = TruckMapper.INSTANCE.truckDtoToTruckEntity(truckDto);

        assertEquals(testTruckEntity.getCode(), truckDto.getCode());
        assertEquals(testTruckEntity.getDescription(), truckDto.getDescription());
        assertEquals(testTruckEntity.getHopType(), truckDto.getHopType());
        assertEquals(testTruckEntity.getLocationCoordinates(), GeoCoordinateMapper.INSTANCE.geoCoordinateDtoToGeoCoordinateEntity(truckDto.getLocationCoordinates()));
        assertEquals(testTruckEntity.getLocationName(), truckDto.getLocationName());
        assertEquals(testTruckEntity.getProcessingDelayMins(), truckDto.getProcessingDelayMins());
        assertEquals(testTruckEntity.getNumberPlate(), truckDto.getNumberPlate());
        assertEquals(testTruckEntity.getRegionGeoJson(), truckDto.getRegionGeoJson());
    }
}