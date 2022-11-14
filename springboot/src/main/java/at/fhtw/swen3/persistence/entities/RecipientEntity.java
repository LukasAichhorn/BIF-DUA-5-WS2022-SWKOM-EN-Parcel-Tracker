package at.fhtw.swen3.persistence.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class RecipientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column
    private String name;

    @Column
    private String street;

    @Column
    private String postalCode;

    @Column
    private String city;

    @Column
    private String country;
    
    
}
