package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.RecipientEntity;
import at.fhtw.swen3.services.dto.Recipient;
import org.mapstruct.Mapper;

@Mapper
public interface RecipientMapper {

    Recipient recipientEntitiyToRecipientDto(RecipientEntity recipientEntity);
    RecipientEntity recipientDtoToRecipientEntity(Recipient  recipientDto);


}
