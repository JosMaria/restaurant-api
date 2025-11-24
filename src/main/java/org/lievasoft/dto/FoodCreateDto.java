package org.lievasoft.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import org.lievasoft.enums.Proportion;
import org.lievasoft.validator.ValidProportion;

public record FoodCreateDto(
        @NotBlank(message = "Name shouldn't be empty, blank or null")
        String name,

        @ValidProportion
        Proportion proportion,

        @Min(value = 1, message = "Price must be greater than zero")
        double price
) {
}
