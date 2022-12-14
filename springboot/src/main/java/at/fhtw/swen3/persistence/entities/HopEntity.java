package at.fhtw.swen3.persistence.entities;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@MappedSuperclass
@SuperBuilder
@RequiredArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Entity
public class HopEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column
    private String hopType;

    @Column
    @Pattern(regexp = "^A-[0-9]{4}")
    private String code;

    @Column
    private String description;

    @Column
    private Integer processingDelayMins;

    @Column
    private String locationName;

    @OneToOne
    @Column
    @NotNull
    private GeoCoordinateEntity locationCoordinates;
}
