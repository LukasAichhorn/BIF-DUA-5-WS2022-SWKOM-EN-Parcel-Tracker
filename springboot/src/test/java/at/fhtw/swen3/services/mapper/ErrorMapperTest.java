package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.ErrorEntity;
import at.fhtw.swen3.services.dto.Error;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ErrorMapperTest {
    Error errorDto;
    ErrorEntity errorEntity;

    @BeforeEach
    void setUp() {
        errorDto = new Error();
        errorDto.setErrorMessage("testErrorMessage");

        errorEntity = new ErrorEntity();
        errorEntity.setErrorMessage("testtesttest");
    }

    @Test
    void errorEntitiyToErrorDto() {
        Error testErrorDto = ErrorMapper.INSTANCE.errorEntitiyToErrorDto(errorEntity);

        assertEquals(testErrorDto.getErrorMessage(), errorEntity.getErrorMessage());
    }

    @Test
    void errorDtoToErrorEntity() {
        ErrorEntity testErrorEntity = ErrorMapper.INSTANCE.errorDtoToErrorEntity(errorDto);

        assertEquals(testErrorEntity.getErrorMessage(), errorDto.getErrorMessage());
    }
}