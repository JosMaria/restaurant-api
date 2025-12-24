package org.lievasoft.dto;

import jakarta.validation.constraints.NotNull;

import java.util.List;

public record TicketCreateDto(
        @NotNull(message = "Waiter Id must not be null")
        Long waiterId,

        @NotNull(message = "Orders must not be null")
        List<OrderCreateDto> orders
) {
    public record OrderCreateDto(
            long foodId,
            int quantity,
            boolean toGo
    ) {
    }
}
