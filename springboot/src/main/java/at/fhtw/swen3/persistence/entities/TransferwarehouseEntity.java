package at.fhtw.swen3.persistence.entities;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;


@SuperBuilder
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@Entity
public class TransferwarehouseEntity extends HopEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @Column
    private String regionGeoJson;

    @Column
    private String logisticsPartner;

    @Column
    private String logisticsPartnerUrl;

    public TransferwarehouseEntity() {
        super();
    }
}
