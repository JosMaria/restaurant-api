package org.lievasoft.dto;

public record OrderCreateDto(
        Long foodId,
        int quantity,
        boolean toGo
) {
}
