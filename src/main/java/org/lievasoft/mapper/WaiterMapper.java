package org.lievasoft.mapper;

import jakarta.enterprise.context.ApplicationScoped;
import org.lievasoft.entity.Waiter;
import org.lievasoft.resource.dto.waiter.WaiterCreateDto;
import org.lievasoft.resource.dto.waiter.WaiterCreateResponse;

@ApplicationScoped
public class WaiterMapper {

    public Waiter toEntity(WaiterCreateDto dto) {
        return new Waiter(dto.name(), dto.lastname(), dto.phoneNumber());
    }

    public WaiterCreateResponse toWaiterResponse(Waiter waiter) {
        return new WaiterCreateResponse(
                waiter.getId(),
                waiter.getName(),
                waiter.getLastname(),
                waiter.getPhoneNumber()
        );
    }
}
