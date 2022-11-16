package at.fhtw.swen3.services.validation.PostalCodeIfAutria;

import at.fhtw.swen3.persistence.entities.RecipientEntity;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class ValidatePostalCodeIfAustriaImpl implements ConstraintValidator<ValidatePostalCodeIfAustria, RecipientEntity> {

    public void initialize(ValidatePostalCodeIfAustria constraintAnnotation) {

    }


    @Override
    public boolean isValid(RecipientEntity recipientEntity, ConstraintValidatorContext constraintValidatorContext) {
        String country = recipientEntity.getCountry();
        String postalCode = recipientEntity.getPostalCode();
        if (country.equals("Austria") || country.equals("Österreich")) {
            return Pattern.matches("^A-[0-9]{4}", postalCode);
        }
        //Skip validation on condition
        return true;

    }
}