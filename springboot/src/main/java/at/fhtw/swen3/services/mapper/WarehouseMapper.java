package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.WarehouseEntity;
import at.fhtw.swen3.services.dto.Warehouse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {WarehouseNextHopsMapper.class})
public interface WarehouseMapper {
    WarehouseMapper INSTANCE = Mappers.getMapper(WarehouseMapper.class);
    Warehouse warehouseEntitiyToWarehouseDto(WarehouseEntity warehouseEntity);
    WarehouseEntity warehouseDtoToWarehouseEntity(Warehouse warehouseDto);


}
