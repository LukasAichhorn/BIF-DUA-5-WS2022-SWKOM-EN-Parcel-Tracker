package at.fhtw.swen3.persistence.entities;

import at.fhtw.swen3.services.validation.TestValuesRecipient;
import org.hibernate.validator.internal.engine.ConstraintViolationImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
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
    private ValidatorFactory factory;
    private Validator validator;
    @BeforeEach
    public void setup(){
        factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
        testEntity = new RecipientEntity();
        testEntity.setCountry("Austria");
        testEntity.setPostalCode("A-1200");
        testEntity.setStreet("Neubaugasse 12a");
        testEntity.setCity("Deutsch Schützen-Eisenberg");
        testEntity.setName("Vorname Nachname");
    }

    @Test
    public void TestValidation_PostalCode_if_Country_is_Austria_error(){
       testEntity.setPostalCode("A-12");
       Set<ConstraintViolation<RecipientEntity>> violations = validator.validate(testEntity);
        System.out.println(violations);
        assertFalse(violations.isEmpty());
    }
    @Test
    public void TestValidation_PostalCode_if_Country_is_Austria_correct(){
        testEntity.setCountry("Österreich");
        testEntity.setPostalCode("A-1120");
        Set<ConstraintViolation<RecipientEntity>> violations = validator.validate(testEntity);
        System.out.println(violations);
        assertTrue(violations.isEmpty());
    }
    @Test
    public void TestValidation_PostalCode_if_Country_isNot_Austria(){
        testEntity.setCountry("Hungary");
        testEntity.setPostalCode("A-12");
        Set<ConstraintViolation<RecipientEntity>> violations = validator.validate(testEntity);
        System.out.println(violations);
        assertTrue(violations.isEmpty());
    }
    @Test
    public void TestValidation_Street_if_Country_is_Austria_correct_01(){
        testEntity.setStreet("Neubaugasse 12a");
        Set<ConstraintViolation<RecipientEntity>> violations = validator.validate(testEntity);
        System.out.println(violations);
        assertTrue(violations.isEmpty());
    }
    @Test
    public void TestValidation_Street_if_Country_is_Austria_correct_02(){
        testEntity.setStreet("Neubaugasse 12/12/12");
        Set<ConstraintViolation<RecipientEntity>> violations = validator.validate(testEntity);
        System.out.println(violations);
        assertTrue(violations.isEmpty());
    }
    @Test
    public void TestValidation_City_if_Country_is_Austria_correct(){
        Set<ConstraintViolation<RecipientEntity>> violations = validator.validate(testEntity);
        System.out.println(violations);
        assertTrue(violations.isEmpty());
    }
    @Test
    public void TestValidation_City_if_Country_is_Austria_error(){
        testEntity.setCity(TestValuesRecipient.CITY_WRONG);
        Set<ConstraintViolation<RecipientEntity>> violations = validator.validate(testEntity);
        System.out.println(violations);
        assertFalse(violations.isEmpty());
    }
    @Test
    public void TestValidation_Name_if_Country_is_Austria_Correct(){
        Set<ConstraintViolation<RecipientEntity>> violations = validator.validate(testEntity);
        System.out.println(violations);
        assertTrue(violations.isEmpty());
    }
    @Test
    public void TestValidation_Name_if_Country_is_Austria_error(){
        testEntity.setName("vorname Nachname");
        Set<ConstraintViolation<RecipientEntity>> violations = validator.validate(testEntity);
        System.out.println(violations);
        assertFalse(violations.isEmpty());
    }

}