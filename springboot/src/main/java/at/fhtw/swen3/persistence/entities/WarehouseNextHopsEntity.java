package at.fhtw.swen3.persistence.entities;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Data
@Entity
public class WarehouseNextHopsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column
    private Integer traveltimeMins;


    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    private HopEntity hop;


}
