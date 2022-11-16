package at.fhtw.swen3.persistence.entities;


import at.fhtw.swen3.services.validation.ValidatorErrorMessages;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Pattern;


@Entity
@Data
public class WarehouseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column
    private Integer level;

    @Column
    @Pattern(regexp = "^[A-Z][a-zA-ZäöüÄÖÜß. -]+[^ ]",message = ValidatorErrorMessages.ERROR_MESSAGE_WAREHOUSE_DESCRIPTION)
    private String description;



/*
    TODO: nextHops korrekt implementieren.
    private List<WarehouseNextHopsEntity> nextHops = new ArrayList<>();
*/
}
