package at.fhtw.swen3.services.validation.NameIfAustria;

import at.fhtw.swen3.persistence.entities.RecipientEntity;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class ValidateNameIfAustriaImpl implements ConstraintValidator<ValidateNameIfAustria, RecipientEntity> {

    public void initialize(ValidateNameIfAustria constraintAnnotation) {

    }


    @Override
    public boolean isValid(RecipientEntity recipientEntity, ConstraintValidatorContext constraintValidatorContext) {
        String country = recipientEntity.getCountry();
        String name = recipientEntity.getName();
        if (country.equals("Austria") || country.equals("Österreich")) {
            return Pattern.matches("^[A-Z][a-zA-ZäöüÄÖÜß. -]+[^ ]", name );

        }
        //Skip validation on condition
        return true;

    }
}