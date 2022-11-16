package at.fhtw.swen3.persistence.entities;



import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.Singular;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.Pattern;
import at.fhtw.swen3.services.validation.ValidatorErrorMessages;




@SuperBuilder
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class WarehouseEntity extends HopEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column
    private Integer level;

    @Column
    @Pattern(regexp = "^[A-Z][a-zA-ZäöüÄÖÜß. -]+[^ ]",message = ValidatorErrorMessages.ERROR_MESSAGE_WAREHOUSE_DESCRIPTION)
    private String description;

    @Singular
    private List<WarehouseNextHopsEntity> nextHops = new ArrayList<>();

}
