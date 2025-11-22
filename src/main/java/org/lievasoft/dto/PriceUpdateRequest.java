package org.lievasoft.dto;

import jakarta.validation.constraints.Min;

public record PriceUpdateRequest(

        @Min(value = 1, message = "Price must be greater than 0")
        double price
) {
}
