package at.fhtw.swen3.persistence.entities;



import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.Singular;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;



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

    @Singular
    private List<WarehouseNextHopsEntity> nextHops = new ArrayList<>();

}
