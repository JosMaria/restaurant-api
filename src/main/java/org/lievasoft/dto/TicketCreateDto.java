package org.lievasoft.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record TicketCreateDto(
        @NotBlank(message = "Waiter id must not be nul, empty or blank")
        String waiterId,

        @Valid
        @NotNull(message = "Orders must not be null")
        @NotEmpty(message = "Orders must not be empty")
        List<OrderCreateDto> orders
) {
    public record OrderCreateDto(
            @NotBlank(message = "Food id must not be null, empty or blank")
            String foodId,
            @Min(value = 1, message = "Quantity must be greater than zero")
            int quantity,
            boolean toGo
    ) {
    }
}
