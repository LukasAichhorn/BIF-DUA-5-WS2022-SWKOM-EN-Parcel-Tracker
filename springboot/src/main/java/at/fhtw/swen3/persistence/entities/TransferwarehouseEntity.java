package at.fhtw.swen3.persistence.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class TransferwarehouseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column
    private String regionGeoJson;

    @Column
    private String logisticsPartner;

    @Column
    private String logisticsPartnerUrl;
}
