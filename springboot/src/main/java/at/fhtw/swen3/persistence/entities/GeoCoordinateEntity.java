package at.fhtw.swen3.persistence.entities;


import lombok.Data;
import lombok.Getter;

import javax.persistence.*;


@Data
@Entity
@Table(name = "geoCoordinatesEntity")
public class GeoCoordinateEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    @Column
    private Double lat;

    @Column
    private Double lon;
}
