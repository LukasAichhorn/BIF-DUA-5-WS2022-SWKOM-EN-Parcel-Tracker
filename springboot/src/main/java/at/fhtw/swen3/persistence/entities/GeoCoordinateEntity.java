package at.fhtw.swen3.persistence.entities;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class GeoCoordinateEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    long id;

    @Column
    private Double lat;

    @Column
    private Double lon;
}
