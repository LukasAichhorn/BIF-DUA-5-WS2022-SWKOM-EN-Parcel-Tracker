package at.fhtw.swen3.services.validation.CityIfAustria;

import at.fhtw.swen3.persistence.entities.RecipientEntity;
import jdk.jfr.Frequency;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class ValidateCityIfAustriaImpl implements ConstraintValidator<ValidateCityIfAustria, RecipientEntity> {

    public void initialize(ValidateCityIfAustria constraintAnnotation) {

    }


    @Override
    public boolean isValid(RecipientEntity recipientEntity, ConstraintValidatorContext constraintValidatorContext) {
        String country = recipientEntity.getCountry();
        String city = recipientEntity.getCity();
        if (country.equals("Austria") || country.equals("Österreich")) {
            return Pattern.matches("^[A-Z][a-zA-ZäöüÄÖÜß. -]+[^ ]", city );

        }
        //Skip validation on condition
        return true;

    }
}