package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.GeoCoordinateEntity;
import at.fhtw.swen3.persistence.entities.TruckEntity;
import at.fhtw.swen3.persistence.entities.WarehouseEntity;
import at.fhtw.swen3.services.dto.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WarehouseMapperTest {

    Warehouse warehouseDto;
    WarehouseEntity warehouseEntity;

    @BeforeEach
    void setUp() {

        GeoCoordinate testGeoCoordinateDto = new GeoCoordinate();
        testGeoCoordinateDto.setLon(1.5);
        testGeoCoordinateDto.setLat(1.5);

        GeoCoordinateEntity testGeoCoordinateEntity = new GeoCoordinateEntity();
        testGeoCoordinateEntity.setLon(2.5);
        testGeoCoordinateEntity.setLat(2.5);

        Hop testHopDto = new Hop();
        testHopDto.setCode("1234");
        testHopDto.setHopType("Store");
        testHopDto.setDescription("TestHop");
        testHopDto.setLocationName("TestHopName");
        testHopDto.setProcessingDelayMins(1);
        testHopDto.setLocationCoordinates(testGeoCoordinateDto);

        WarehouseNextHops testWhnh = new WarehouseNextHops();
        testWhnh.setTraveltimeMins(1);
        testWhnh.setHop(testHopDto);

        warehouseDto = new Warehouse();
        warehouseDto.setCode("1234");
        warehouseDto.setHopType("Store");
        warehouseDto.setDescription("TestHop");
        warehouseDto.setLocationName("TestHopName");
        warehouseDto.setProcessingDelayMins(1);
        warehouseDto.setLocationCoordinates(testGeoCoordinateDto);
        warehouseDto.setLevel(3);
        warehouseDto.addNextHopsItem(testWhnh);

        warehouseEntity = WarehouseEntity.builder()
                .code("4321")
                .hopType("House")
                .description("TestHopEntity")
                .locationName("TestHopEntityName")
                .processingDelayMins(2)
                .locationCoordinates(testGeoCoordinateEntity)
                .level(4)
                .nextHop(WarehouseNextHopsMapper.INSTANCE.warehouseNextHopsDtoToWarehouseNextHopsEntity(testWhnh))
                .build();
    }

    @Test
    void warehouseEntitiyToWarehouseDto() {
        Warehouse testWarehouseDto = WarehouseMapper.INSTANCE.warehouseEntitiyToWarehouseDto(warehouseEntity);

        assertEquals(testWarehouseDto.getCode(), warehouseEntity.getCode());
        assertEquals(testWarehouseDto.getDescription(), warehouseEntity.getDescription());
        assertEquals(testWarehouseDto.getHopType(), warehouseEntity.getHopType());
        assertEquals(testWarehouseDto.getLocationCoordinates(), GeoCoordinateMapper.INSTANCE.geoCoordinateEntitiyToGeoCoordinateDto(warehouseEntity.getLocationCoordinates()));
        assertEquals(testWarehouseDto.getLocationName(), warehouseEntity.getLocationName());
        assertEquals(testWarehouseDto.getProcessingDelayMins(), warehouseEntity.getProcessingDelayMins());
        assertEquals(testWarehouseDto.getLevel(), warehouseEntity.getLevel());
        assertEquals(testWarehouseDto.getNextHops().get(0), WarehouseNextHopsMapper.INSTANCE.warehouseNextHopsEntitiyToWarehouseNextHopsDto(warehouseEntity.getNextHops().get(0)));
    }

    @Test
    void warehouseDtoToWarehouseEntity() {
        WarehouseEntity testWarehouseEntity = WarehouseMapper.INSTANCE.warehouseDtoToWarehouseEntity(warehouseDto);

        assertEquals(testWarehouseEntity.getCode(), warehouseDto.getCode());
        assertEquals(testWarehouseEntity.getDescription(), warehouseDto.getDescription());
        assertEquals(testWarehouseEntity.getHopType(), warehouseDto.getHopType());
        assertEquals(testWarehouseEntity.getLocationCoordinates(), GeoCoordinateMapper.INSTANCE.geoCoordinateDtoToGeoCoordinateEntity(warehouseDto.getLocationCoordinates()));
        assertEquals(testWarehouseEntity.getLocationName(), warehouseDto.getLocationName());
        assertEquals(testWarehouseEntity.getProcessingDelayMins(), warehouseDto.getProcessingDelayMins());
        assertEquals(testWarehouseEntity.getLevel(), warehouseDto.getLevel());
        assertEquals(testWarehouseEntity.getNextHops().get(0), WarehouseNextHopsMapper.INSTANCE.warehouseNextHopsDtoToWarehouseNextHopsEntity(warehouseDto.getNextHops().get(0)));
    }
}