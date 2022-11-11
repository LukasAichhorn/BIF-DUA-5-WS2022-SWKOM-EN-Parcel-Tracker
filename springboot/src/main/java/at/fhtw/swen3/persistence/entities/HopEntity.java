package at.fhtw.swen3.persistence.entities;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class HopEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column
    private String hopType;

    @Column
    private String code;

    @Column
    private String description;

    @Column
    private Integer processingDelayMins;

    @Column
    private String locationName;

    @OneToOne
    @Column
    private GeoCoordinateEntity locationCoordinates;
}
