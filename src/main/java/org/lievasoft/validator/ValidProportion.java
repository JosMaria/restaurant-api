package org.lievasoft.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ProportionValidator.class)
public @interface ValidProportion {

    String message() default "Proportion must be a valid value";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
