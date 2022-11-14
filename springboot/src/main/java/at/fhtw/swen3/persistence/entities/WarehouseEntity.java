package at.fhtw.swen3.persistence.entities;


import lombok.Data;

import javax.persistence.*;


@Entity
@Data
public class WarehouseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column
    private Integer level;



/*
    TODO: nextHops korrekt implementieren.
    private List<WarehouseNextHopsEntity> nextHops = new ArrayList<>();
*/
}
