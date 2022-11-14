package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.WarehouseEntity;
import at.fhtw.swen3.services.dto.Warehouse;
import org.mapstruct.Mapper;

@Mapper
public interface WarehouseMapper {

    Warehouse warehouseEntitiyToWarehouseDto(WarehouseEntity warehouseEntity);
    WarehouseEntity warehouseDtoToWarehouseEntity(Warehouse warehouseDto);


}
