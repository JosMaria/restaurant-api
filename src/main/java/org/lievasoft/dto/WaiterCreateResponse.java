package org.lievasoft.dto;

public record WaiterCreateResponse(
        Long id,
        String name,
        String lastname,
        String phoneNumber
) {
}
