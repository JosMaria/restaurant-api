package org.lievasoft.exception;

import org.lievasoft.enums.Proportion;

public class FoodExistsException extends RuntimeException {

    public FoodExistsException(String name, Proportion proportion) {
        super("Food with name '%s' and proportion '%s' already exists".formatted(name, proportion));
    }
}
