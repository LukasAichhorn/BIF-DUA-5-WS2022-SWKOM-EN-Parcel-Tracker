package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.GeoCoordinateEntity;
import at.fhtw.swen3.persistence.entities.HopEntity;
import at.fhtw.swen3.persistence.entities.TransferwarehouseEntity;
import at.fhtw.swen3.services.dto.GeoCoordinate;
import at.fhtw.swen3.services.dto.Hop;
import at.fhtw.swen3.services.dto.Transferwarehouse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TransferwarehouseMapperTest {

    Transferwarehouse tsfwhDto;
    TransferwarehouseEntity tsfwhEntity;

    @BeforeEach
    void setUp() {
        GeoCoordinate testGeoCoordinateDto = new GeoCoordinate();
        testGeoCoordinateDto.setLon(1.5);
        testGeoCoordinateDto.setLat(1.5);

        GeoCoordinateEntity testGeoCoordinateEntity = new GeoCoordinateEntity();
        testGeoCoordinateEntity.setLon(2.5);
        testGeoCoordinateEntity.setLat(2.5);

        tsfwhDto = new Transferwarehouse();
        tsfwhDto.setCode("1234");
        tsfwhDto.setHopType("Store");
        tsfwhDto.setDescription("TestHop");
        tsfwhDto.setLocationName("TestHopName");
        tsfwhDto.setProcessingDelayMins(1);
        tsfwhDto.setLocationCoordinates(testGeoCoordinateDto);
        tsfwhDto.setLogisticsPartner("LKW Walter");
        tsfwhDto.setLogisticsPartnerUrl("www.lkw-walter.at");
        tsfwhDto.setRegionGeoJson("{name:'test'}");

        tsfwhEntity = TransferwarehouseEntity.builder()
                .code("4321")
                .hopType("House")
                .description("TestHopEntity")
                .locationName("TestHopEntityName")
                .processingDelayMins(2)
                .locationCoordinates(testGeoCoordinateEntity)
                .logisticsPartner("LKW WEISS")
                .logisticsPartnerUrl("www.lkw-weiss.at")
                .regionGeoJson("{name:'testEntity'}")
                .build();
    }

    @Test
    void transferwarehouseEntitiyToTransferwarehouseDto() {
        Transferwarehouse testTsfwhDto = TransferwarehouseMapper.INSTANCE.transferwarehouseEntitiyToTransferwarehouseDto(tsfwhEntity);

        assertEquals(testTsfwhDto.getCode(), tsfwhEntity.getCode());
        assertEquals(testTsfwhDto.getDescription(), tsfwhEntity.getDescription());
        assertEquals(testTsfwhDto.getHopType(), tsfwhEntity.getHopType());
        assertEquals(testTsfwhDto.getLocationCoordinates(), GeoCoordinateMapper.INSTANCE.geoCoordinateEntitiyToGeoCoordinateDto(tsfwhEntity.getLocationCoordinates()));
        assertEquals(testTsfwhDto.getLocationName(), tsfwhEntity.getLocationName());
        assertEquals(testTsfwhDto.getProcessingDelayMins(), tsfwhEntity.getProcessingDelayMins());
        assertEquals(testTsfwhDto.getLogisticsPartner(), tsfwhEntity.getLogisticsPartner());
        assertEquals(testTsfwhDto.getLogisticsPartnerUrl(), tsfwhEntity.getLogisticsPartnerUrl());
        assertEquals(testTsfwhDto.getRegionGeoJson(), tsfwhEntity.getRegionGeoJson());
    }

    @Test
    void transferwarehouseDtoToTransferwarehouseEntity() {
        TransferwarehouseEntity testTsfwhEntity = TransferwarehouseMapper.INSTANCE.transferwarehouseDtoToTransferwarehouseEntity(tsfwhDto);

        assertEquals(testTsfwhEntity.getCode(), tsfwhDto.getCode());
        assertEquals(testTsfwhEntity.getDescription(), tsfwhDto.getDescription());
        assertEquals(testTsfwhEntity.getHopType(), tsfwhDto.getHopType());
        assertEquals(testTsfwhEntity.getLocationCoordinates(), GeoCoordinateMapper.INSTANCE.geoCoordinateDtoToGeoCoordinateEntity(tsfwhDto.getLocationCoordinates()));
        assertEquals(testTsfwhEntity.getLocationName(), tsfwhDto.getLocationName());
        assertEquals(testTsfwhEntity.getProcessingDelayMins(), tsfwhDto.getProcessingDelayMins());
        assertEquals(testTsfwhEntity.getLogisticsPartner(), tsfwhDto.getLogisticsPartner());
        assertEquals(testTsfwhEntity.getLogisticsPartnerUrl(), tsfwhDto.getLogisticsPartnerUrl());
        assertEquals(testTsfwhEntity.getRegionGeoJson(), tsfwhDto.getRegionGeoJson());
    }
}