package org.lievasoft.dto;

import java.util.List;

public record TicketCreateDto(
        List<OrderCreateDto> orders,
        Long waiterId
) {
}
