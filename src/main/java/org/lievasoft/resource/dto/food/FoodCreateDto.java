package org.lievasoft.resource.dto.food;

import jakarta.validation.constraints.NotBlank;
import org.lievasoft.enums.Proportion;
import org.lievasoft.resource.validator.PriceGreaterThanZero;

public record FoodCreateDto(
        @NotBlank(message = "Name shouldn't be empty, blank or null")
        String name,

        Proportion proportion,

        @PriceGreaterThanZero
        double price
) {
}
