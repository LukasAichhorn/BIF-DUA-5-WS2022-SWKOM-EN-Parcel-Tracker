package at.fhtw.swen3.persistence.entities;


import lombok.Data;

import javax.persistence.*;


@Data
public class WarehouseNextHopsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column
    private Integer traveltimeMins;


    @Column
    private HopEntity hop;
}
