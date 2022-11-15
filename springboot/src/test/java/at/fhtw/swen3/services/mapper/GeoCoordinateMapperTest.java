package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.GeoCoordinateEntity;
import at.fhtw.swen3.services.dto.GeoCoordinate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GeoCoordinateMapperTest {

    GeoCoordinate geoCoordinate;
    GeoCoordinateEntity geoCoordinateEntity;

    @BeforeEach
    void setUp() {
        geoCoordinate = new GeoCoordinate();
        geoCoordinate.setLat(1.5);
        geoCoordinate.setLon(1.5);

        geoCoordinateEntity = new GeoCoordinateEntity();
        geoCoordinateEntity.setLat(2.5);
        geoCoordinateEntity.setLon(2.5);
    }

    @Test
    void geoCoordinateEntitiyToGeoCoordinateDto() {
        GeoCoordinate testGeoCoordinate = GeoCoordinateMapper.INSTANCE.geoCoordinateEntitiyToGeoCoordinateDto(geoCoordinateEntity);

        assertEquals(testGeoCoordinate.getLat(), geoCoordinateEntity.getLat());
        assertEquals(testGeoCoordinate.getLon(), geoCoordinateEntity.getLon());
    }

    @Test
    void geoCoordinateDtoToGeoCoordinateEntity() {
        GeoCoordinateEntity testGeoCoordinateEntity = GeoCoordinateMapper.INSTANCE.geoCoordinateDtoToGeoCoordinateEntity(geoCoordinate);

        assertEquals(testGeoCoordinateEntity.getLat(), geoCoordinate.getLat());
        assertEquals(testGeoCoordinateEntity.getLon(), geoCoordinate.getLon());
    }
}