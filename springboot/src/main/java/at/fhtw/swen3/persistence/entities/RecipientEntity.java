package at.fhtw.swen3.persistence.entities;

import at.fhtw.swen3.services.validation.ValidatePostalCodeIfAustria;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Pattern;

@Entity
@Data
@ValidatePostalCodeIfAustria
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
