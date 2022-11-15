package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.TransferwarehouseEntity;
import at.fhtw.swen3.services.dto.Transferwarehouse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TransferwarehouseMapper {
    TransferwarehouseMapper INSTANCE = Mappers.getMapper(TransferwarehouseMapper.class);
    Transferwarehouse transferwarehouseEntitiyToTransferwarehouseDto(TransferwarehouseEntity transferwarehouseEntity);
    TransferwarehouseEntity transferwarehouseDtoToTransferwarehouseEntity(Transferwarehouse transferwarehouseDto);


}
