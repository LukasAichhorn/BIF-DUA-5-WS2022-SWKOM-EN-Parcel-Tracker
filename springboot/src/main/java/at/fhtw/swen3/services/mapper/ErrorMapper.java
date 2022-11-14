package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.ErrorEntity;
import at.fhtw.swen3.services.dto.Error;
import org.mapstruct.Mapper;

@Mapper
public interface ErrorMapper {

    Error errorEntitiyToErrorDto(ErrorEntity errorEntity);
    ErrorEntity errorDtoToErrorEntity(Error errorDto);


}
