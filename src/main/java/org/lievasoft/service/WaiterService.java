package org.lievasoft.service;

import jakarta.enterprise.context.ApplicationScoped;
import org.lievasoft.dto.WaiterResponse;
import org.lievasoft.entity.Waiter;
import org.lievasoft.repository.WaiterRepository;

@ApplicationScoped
public class WaiterService {

    private final WaiterRepository waiterRepository;

    public WaiterService(WaiterRepository waiterRepository) {
        this.waiterRepository = waiterRepository;
    }

    public WaiterResponse create(WaiterCreateDto payload) {
        isNumberAlreadyRegistered(payload.phoneNumber());
        var waiterToPersist = mapToWaiter(payload);
        waiterRepository.create(waiterToPersist);
        return mapToWaiterResponse(waiterToPersist);
    }

    //TODO: Implement this method
    public boolean isNumberAlreadyRegistered(String number) {
        return false;
    }

    private Waiter mapToWaiter(WaiterCreateDto payload) {
        return new Waiter(payload.name(), payload.lastname(), payload.phoneNumber());
    }

    private WaiterResponse mapToWaiterResponse(Waiter waiter) {
        return new WaiterResponse(
                waiter.getId(),
                waiter.getName(),
                waiter.getLastname(),
                waiter.getPhoneNumber()
        );
    }
}
