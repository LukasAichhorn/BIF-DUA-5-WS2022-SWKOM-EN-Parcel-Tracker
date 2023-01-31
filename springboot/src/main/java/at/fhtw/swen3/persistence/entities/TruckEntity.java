package at.fhtw.swen3.persistence.entities;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Entity
@SuperBuilder
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)

public class TruckEntity extends HopEntity{


    @Column
    private String regionGeoJson;

    @Column
    private String numberPlate;


    public TruckEntity() {
        super();
    }
}
