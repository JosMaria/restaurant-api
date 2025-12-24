package org.lievasoft.resource.dto.waiter;

public record WaiterCreateResponse(
        String id,
        String name,
        String lastname,
        String phoneNumber
) {
}
