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
    public void TestValidation(){
        testEntity = new RecipientEntity();
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
       testEntity.setCountry("Austria");
       testEntity.setPostalCode("A-12");
        Set<ConstraintViolation<RecipientEntity>> violations = validator.validate(testEntity);
        assertFalse(violations.isEmpty());


    }
    }