package at.fhtw.swen3.persistence.entities;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Data
@Entity
public class WarehouseNextHopsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column
    private Integer traveltimeMins;


    @Column
    @NotNull
    @ManyToOne
    private HopEntity hop;
}
