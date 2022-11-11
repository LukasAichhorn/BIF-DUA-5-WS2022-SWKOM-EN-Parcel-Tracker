package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.WarehouseNextHopsEntity;
import at.fhtw.swen3.services.dto.WarehouseNextHops;
import org.mapstruct.Mapper;

@Mapper
public interface WarehouseNextHopsMapper {

    WarehouseNextHops warehouseNextHopsEntitiyToWarehouseNextHopsDto(WarehouseNextHopsEntity warehouseNextHopsEntity);
    WarehouseNextHopsEntity warehouseNextHopsDtoToWarehouseNextHopsEntity(WarehouseNextHops warehouseNextHopsDto);


}
