package org.lievasoft.dto;

import org.lievasoft.enums.Proportion;

public record FoodCreateResponse(
        long id,
        String name,
        Proportion proportion,
        double price
) {
}
