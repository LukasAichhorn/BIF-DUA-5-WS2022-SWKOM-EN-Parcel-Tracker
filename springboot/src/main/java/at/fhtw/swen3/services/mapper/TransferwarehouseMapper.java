package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.TransferwarehouseEntity;
import at.fhtw.swen3.services.dto.Transferwarehouse;
import org.mapstruct.Mapper;

@Mapper
public interface TransferwarehouseMapper {

    Transferwarehouse transferwarehouseEntitiyToTransferwarehouseDto(TransferwarehouseEntity transferwarehouseEntity);
    TransferwarehouseEntity transferwarehouseDtoToTransferwarehouseEntity(Transferwarehouse transferwarehouseDto);


}
