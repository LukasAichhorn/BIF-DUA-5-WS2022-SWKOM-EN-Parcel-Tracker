package at.fhtw.swen3.persistence.entities;

import at.fhtw.swen3.services.validation.PostalCodeIfAutria.ValidatePostalCodeIfAustria;
import at.fhtw.swen3.services.validation.StreetIfAustria.ValidateStreetIfAustria;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@ValidatePostalCodeIfAustria(message = "PostalCode-error")
@ValidateStreetIfAustria(message = "Street-error")
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
