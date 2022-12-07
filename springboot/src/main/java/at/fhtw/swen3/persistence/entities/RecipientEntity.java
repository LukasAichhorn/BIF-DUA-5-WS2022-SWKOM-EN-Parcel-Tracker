package at.fhtw.swen3.persistence.entities;

import at.fhtw.swen3.services.validation.CityIfAustria.ValidateCityIfAustria;
import at.fhtw.swen3.services.validation.NameIfAustria.ValidateNameIfAustria;
import at.fhtw.swen3.services.validation.PostalCodeIfAutria.ValidatePostalCodeIfAustria;
import at.fhtw.swen3.services.validation.StreetIfAustria.ValidateStreetIfAustria;
import at.fhtw.swen3.services.validation.ValidatorErrorMessages;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

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
    private String id;

    @Column
    @NotNull
    @Pattern(regexp = "^[A-Z][a-zA-ZäöüÄÖÜß. -]+[^ ]")
    private String name;

    @Column
    @NotNull
    @Pattern(regexp = "^[a-zA-ZäöüÄÖÜß.]+ ([0-9]+[a-z]|([0-9]{2}\\/){0,2}[0-9]{2})")
    private String street;

    @Column
    @NotNull
    @Pattern(regexp = "^A-[0-9]{4}")
    private String postalCode;

    @Column
    @NotNull
    @Pattern(regexp = "^[A-Z][a-zA-ZäöüÄÖÜß. -]+[^ ]")
    private String city;

    @Column
    @NotNull
    private String country;
    
    
}
