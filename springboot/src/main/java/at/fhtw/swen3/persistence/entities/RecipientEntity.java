package at.fhtw.swen3.persistence.entities;

import at.fhtw.swen3.services.validation.CityIfAustria.ValidateCityIfAustria;
import at.fhtw.swen3.services.validation.NameIfAustria.ValidateNameIfAustria;
import at.fhtw.swen3.services.validation.PostalCodeIfAutria.ValidatePostalCodeIfAustria;
import at.fhtw.swen3.services.validation.StreetIfAustria.ValidateStreetIfAustria;
import at.fhtw.swen3.services.validation.ValidatorErrorMessages;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@ValidatePostalCodeIfAustria(message = ValidatorErrorMessages.ERROR_MESSAGE_POSTAL)
@ValidateStreetIfAustria(message = ValidatorErrorMessages.ERROR_MESSAGE_STREET)
@ValidateCityIfAustria(message =ValidatorErrorMessages.ERROR_MESSAGE_CITY)
@ValidateNameIfAustria(message = ValidatorErrorMessages.ERROR_MESSAGE_NAME)
public class RecipientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @NotNull
    private long id;

    @Column
    @NotNull
    private String name;

    @Column
    @NotNull
    private String street;

    @Column
    @NotNull
    private String postalCode;

    @Column
    @NotNull
    private String city;

    @Column
    @NotNull
    private String country;
    
    
}
