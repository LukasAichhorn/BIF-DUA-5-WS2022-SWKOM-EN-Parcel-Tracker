package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.GeoCoordinateEntity;
import at.fhtw.swen3.persistence.entities.HopEntity;
import at.fhtw.swen3.persistence.entities.WarehouseNextHopsEntity;
import at.fhtw.swen3.services.dto.GeoCoordinate;
import at.fhtw.swen3.services.dto.Hop;
import at.fhtw.swen3.services.dto.WarehouseNextHops;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WarehouseNextHopsMapperTest {

    WarehouseNextHops whnhDto;
    WarehouseNextHopsEntity whnhEntity;

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

        whnhDto = new WarehouseNextHops();
        whnhDto.setHop(testHopDto);
        whnhDto.setTraveltimeMins(1);

        whnhEntity = new WarehouseNextHopsEntity();
        whnhEntity.setHop(HopMapper.INSTANCE.hopDtoToHopEntity(testHopDto));
        whnhEntity.setTraveltimeMins(2);
    }

    @Test
    void warehouseNextHopsEntitiyToWarehouseNextHopsDto() {
        WarehouseNextHops testWhnhDto = WarehouseNextHopsMapper.INSTANCE.warehouseNextHopsEntitiyToWarehouseNextHopsDto(whnhEntity);

        assertEquals(testWhnhDto.getTraveltimeMins(), whnhEntity.getTraveltimeMins());
        assertEquals(testWhnhDto.getHop(), HopMapper.INSTANCE.hopEntitiyToHopDto(whnhEntity.getHop()));
    }

    @Test
    void warehouseNextHopsDtoToWarehouseNextHopsEntity() {
        WarehouseNextHopsEntity testWhnhEntity = WarehouseNextHopsMapper.INSTANCE.warehouseNextHopsDtoToWarehouseNextHopsEntity(whnhDto);

        assertEquals(testWhnhEntity.getTraveltimeMins(), whnhDto.getTraveltimeMins());
        assertEquals(testWhnhEntity.getHop(), HopMapper.INSTANCE.hopDtoToHopEntity(whnhDto.getHop()));
    }
}