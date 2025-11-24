package org.lievasoft.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.lievasoft.enums.Proportion;

import java.util.Arrays;

public class ProportionValidator implements ConstraintValidator<ValidProportion, Proportion> {

    @Override
    public boolean isValid(Proportion proportion, ConstraintValidatorContext constraintValidatorContext) {
        return Arrays.asList(Proportion.values()).contains(proportion);
    }
}
