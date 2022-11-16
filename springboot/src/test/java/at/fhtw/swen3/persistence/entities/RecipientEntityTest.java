package at.fhtw.swen3.persistence.entities;

import org.hibernate.validator.internal.engine.ConstraintViolationImpl;
import org.junit.jupiter.api.Test;


import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Arrays;
import java.util.Optional;
import java.util.Set;


import static org.junit.jupiter.api.Assertions.*;

public class RecipientEntityTest {
    private RecipientEntity testEntity;

    @Test
    public void TestValidation_PostalCode_if_Country_is_Austria_error(){
        testEntity = new RecipientEntity();
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
       testEntity.setCountry("Austria");
       testEntity.setPostalCode("A-12");
       testEntity.setStreet("Neubaugasse 12a");
        Set<ConstraintViolation<RecipientEntity>> violations = validator.validate(testEntity);
        System.out.println(violations);
        assertFalse(violations.isEmpty());
    }
    @Test
    public void TestValidation_PostalCode_if_Country_is_Austria_correct(){
        testEntity = new RecipientEntity();
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        testEntity.setCountry("Österreich");
        testEntity.setPostalCode("A-1120");
        testEntity.setStreet("Neubaugasse 12a");
        Set<ConstraintViolation<RecipientEntity>> violations = validator.validate(testEntity);
        System.out.println(violations);
        assertTrue(violations.isEmpty());
    }
    @Test
    public void TestValidation_PostalCode_if_Country_isNot_Austria(){
        testEntity = new RecipientEntity();
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        testEntity.setCountry("Hungary");
        testEntity.setPostalCode("A-12");
        testEntity.setStreet("Neubaugasse 12a");
        Set<ConstraintViolation<RecipientEntity>> violations = validator.validate(testEntity);
        System.out.println(violations);
        assertTrue(violations.isEmpty());
    }
    @Test
    public void TestValidation_Street_if_Country_is_Austria_correct_01(){
        testEntity = new RecipientEntity();
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        testEntity.setCountry("Austria");
        testEntity.setPostalCode("A-1120");
        testEntity.setStreet("Neubaugasse 12a");
        Set<ConstraintViolation<RecipientEntity>> violations = validator.validate(testEntity);
        System.out.println(violations);
        assertTrue(violations.isEmpty());
    }
    @Test
    public void TestValidation_Street_if_Country_is_Austria_correct_02(){
        testEntity = new RecipientEntity();
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        testEntity.setCountry("Austria");
        testEntity.setPostalCode("A-1120");
        testEntity.setStreet("Neubaugasse 12/12/12");
        Set<ConstraintViolation<RecipientEntity>> violations = validator.validate(testEntity);
        System.out.println(violations);
        assertTrue(violations.isEmpty());
    }
}