package org.lievasoft.exception;

public class FoodNotFoundException extends RuntimeException {

    public FoodNotFoundException(Long foodId) {
        super("Food with ID: '%s' not found".formatted(foodId));
    }
}
