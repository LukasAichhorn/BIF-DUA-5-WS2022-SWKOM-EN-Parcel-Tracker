package at.fhtw.swen3.persistence.entities;



import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.Singular;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import at.fhtw.swen3.services.validation.ValidatorErrorMessages;
import org.hibernate.annotations.Cascade;


@SuperBuilder
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@Entity
public class WarehouseEntity extends HopEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Column
    private Integer level;


    @Singular
    @NotNull
    @OneToMany(cascade = CascadeType.ALL)
    private List<WarehouseNextHopsEntity> nextHops = new ArrayList<>();

    public WarehouseEntity() {};



}
