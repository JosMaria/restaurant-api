package org.lievasoft.dto;

public record OrderCreateDto(
        long foodId,
        int quantity,
        boolean toGo
) {
}
