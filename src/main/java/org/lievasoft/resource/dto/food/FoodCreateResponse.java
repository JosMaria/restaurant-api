package org.lievasoft.resource.dto.food;

import org.lievasoft.enums.Proportion;

public record FoodCreateResponse(
        String id,
        String name,
        Proportion proportion,
        double price
) {
}
