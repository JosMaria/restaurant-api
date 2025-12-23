package org.lievasoft.resource.dto.food;

import org.lievasoft.validator.PriceGreaterThanZero;

public record PriceUpdateRequest(

        @PriceGreaterThanZero
        double price
) {
}
