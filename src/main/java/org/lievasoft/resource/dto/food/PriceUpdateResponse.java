package org.lievasoft.resource.dto.food;

import org.lievasoft.enums.Proportion;

public record PriceUpdateResponse(
        String id,
        double price,
        String name,
        Proportion proportion
) {
}
