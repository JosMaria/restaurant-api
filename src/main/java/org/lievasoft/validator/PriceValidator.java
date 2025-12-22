package org.lievasoft.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PriceValidator implements ConstraintValidator<PriceGreaterThanZero, Double> {

    @Override
    public boolean isValid(Double price, ConstraintValidatorContext context) {
        return price > 0;
    }
}
