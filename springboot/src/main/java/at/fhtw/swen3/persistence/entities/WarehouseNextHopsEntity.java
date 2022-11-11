package at.fhtw.swen3.persistence.entities;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class WarehouseNextHopsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long Id;

    @Column
    private Integer traveltimeMins;

    /*
    TODO: db beziehung richtig setzen. (1to1, mto1, etc.)
    @Column
    private HopEntity hop;*/
}
