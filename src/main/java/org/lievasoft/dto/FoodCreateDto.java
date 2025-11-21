package org.lievasoft.dto;

import org.lievasoft.enums.Proportion;

public record FoodCreateDto(
        String name,
        Proportion proportion,
        double price
) {
}
