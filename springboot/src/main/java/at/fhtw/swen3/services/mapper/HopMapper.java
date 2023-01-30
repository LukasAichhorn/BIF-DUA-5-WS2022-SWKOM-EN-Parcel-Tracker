package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.HopEntity;
import at.fhtw.swen3.services.dto.Hop;
import org.aspectj.lang.annotation.Before;
import org.mapstruct.BeforeMapping;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {GeoCoordinateMapper.class})
public interface HopMapper {
    HopMapper INSTANCE = Mappers.getMapper(HopMapper.class);




    Hop hopEntitiyToHopDto(HopEntity hopEntity);
    HopEntity hopDtoToHopEntity(Hop hopDto);


}