package at.fhtw.swen3.services.validation.NameIfAustria;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Target(TYPE)
@Retention(RUNTIME)
@Constraint(validatedBy = { ValidateNameIfAustriaImpl.class })
public @interface ValidateNameIfAustria {

    String message();

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
