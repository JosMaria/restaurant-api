package org.lievasoft.dto;

import jakarta.validation.constraints.NotBlank;
import org.lievasoft.enums.Proportion;
import org.lievasoft.validator.PriceGreaterThanZero;

public record FoodCreateDto(
        @NotBlank(message = "Name shouldn't be empty, blank or null")
        String name,

        Proportion proportion,

        @PriceGreaterThanZero
        double price
) {
}

