package org.lievasoft.service;

import jakarta.enterprise.context.ApplicationScoped;
import org.lievasoft.exception.PhoneNumberExistsException;
import org.lievasoft.mapper.WaiterMapper;
import org.lievasoft.repository.WaiterRepository;
import org.lievasoft.resource.dto.waiter.WaiterCreateDto;
import org.lievasoft.resource.dto.waiter.WaiterCreateResponse;

import java.util.Objects;

@ApplicationScoped
public class WaiterService {

    private final WaiterRepository waiterRepository;
    private final WaiterMapper waiterMapper;

    public WaiterService(WaiterRepository waiterRepository, WaiterMapper waiterMapper) {
        this.waiterRepository = waiterRepository;
        this.waiterMapper = waiterMapper;
    }

    public WaiterCreateResponse create(WaiterCreateDto payload) {
        var phoneNumber = payload.phoneNumber();
        if (Objects.nonNull(phoneNumber)) {
            var isRegistered = waiterRepository.isRegisteredNumber(phoneNumber);
            if (isRegistered) throw new PhoneNumberExistsException(phoneNumber);
        }

        var waiterToPersist = waiterMapper.toEntity(payload);
        waiterRepository.create(waiterToPersist);
        return waiterMapper.toWaiterResponse(waiterToPersist);
    }
}
