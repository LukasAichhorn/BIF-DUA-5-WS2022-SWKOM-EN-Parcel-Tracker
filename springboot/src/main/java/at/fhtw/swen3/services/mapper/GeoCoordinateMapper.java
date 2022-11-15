package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.GeoCoordinateEntity;
import at.fhtw.swen3.services.dto.GeoCoordinate;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface GeoCoordinateMapper {
    GeoCoordinateMapper INSTANCE = Mappers.getMapper(GeoCoordinateMapper.class);
    GeoCoordinate geoCoordinateEntitiyToGeoCoordinateDto(GeoCoordinateEntity geoCoordinateEntity);
    GeoCoordinateEntity geoCoordinateDtoToGeoCoordinateEntity(GeoCoordinate geoCoordinateDto);


}
