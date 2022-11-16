package at.fhtw.swen3.services.validation.StreetIfAustria;

import at.fhtw.swen3.persistence.entities.RecipientEntity;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class ValidateStreetIfAustriaImpl implements ConstraintValidator<ValidateStreetIfAustria, RecipientEntity> {

    public void initialize(ValidateStreetIfAustria constraintAnnotation) {

    }


    @Override
    public boolean isValid(RecipientEntity recipientEntity, ConstraintValidatorContext constraintValidatorContext) {
        String street = recipientEntity.getStreet();
        if (street.equals("Austria") || street.equals("Österreich")) {
            return Pattern.matches("^[a-zA-ZäöüÄÖÜß.]+ ([0-9]+[a-z]|([0-9]{2}\\/){0,2}[0-9]{2})", street);

        }
        //Skip validation on condition
        return true;

    }
}