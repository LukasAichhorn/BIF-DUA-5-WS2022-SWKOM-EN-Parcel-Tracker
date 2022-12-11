package at.fhtw.swen3.persistence.entities;


import lombok.Data;

import javax.persistence.*;


@Data
@Entity
public class GeoCoordinateEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    @Column
    private Double lat;

    @Column
    private Double lon;
}
