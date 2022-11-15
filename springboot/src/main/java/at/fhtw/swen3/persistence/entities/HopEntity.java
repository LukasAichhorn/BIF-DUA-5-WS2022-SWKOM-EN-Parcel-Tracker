package at.fhtw.swen3.persistence.entities;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@MappedSuperclass
@SuperBuilder
@RequiredArgsConstructor
@Getter
@Setter
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
