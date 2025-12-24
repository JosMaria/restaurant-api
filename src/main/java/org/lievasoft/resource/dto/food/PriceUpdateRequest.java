package org.lievasoft.resource.dto.food;

import org.lievasoft.resource.validator.PriceGreaterThanZero;

public record PriceUpdateRequest(
        @PriceGreaterThanZero
        double price
) {
}
