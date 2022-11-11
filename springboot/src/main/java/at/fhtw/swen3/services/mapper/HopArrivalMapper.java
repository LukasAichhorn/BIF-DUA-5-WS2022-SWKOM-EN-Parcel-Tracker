package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.HopArrivalEntity;
import at.fhtw.swen3.services.dto.HopArrival;
import org.mapstruct.Mapper;

@Mapper
public interface HopArrivalMapper {

    HopArrival hopArrivalEntitiyToHopArrivalDto(HopArrivalEntity hopArrivalEntity);
    HopArrivalEntity hopArrivalDtoToHopArrivalEntity(HopArrival hopArrivalDto);


}