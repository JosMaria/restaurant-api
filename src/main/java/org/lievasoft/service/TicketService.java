package org.lievasoft.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityNotFoundException;
import org.lievasoft.dto.OrderCreateDto;
import org.lievasoft.dto.TicketCreateDto;
import org.lievasoft.dto.TicketResponse;
import org.lievasoft.entity.Waiter;
import org.lievasoft.kafka.producer.TicketProducer;
import org.lievasoft.repository.FoodRepository;
import org.lievasoft.repository.TicketRepository;
import org.lievasoft.repository.WaiterRepository;

import java.util.List;

@ApplicationScoped
public class TicketService {

    private final FoodRepository foodRepository;
    private final WaiterRepository waiterRepository;
    private final TicketProducer ticketProducer;

    public TicketService(TicketProducer ticketProducer, WaiterRepository waiterRepository,
                         FoodRepository foodRepository) {
        this.ticketProducer = ticketProducer;
        this.waiterRepository = waiterRepository;
        this.foodRepository = foodRepository;
    }

    public TicketResponse registerTicket(TicketCreateDto payload) {
        var obtainedWaiter = waiterRepository.findByIdOptional(payload.waiterId())
                .orElseThrow(() -> {
                    var waiterId = payload.waiterId();
                    String errorMsg = "Waiter with Id: %s does not exists.".formatted(waiterId);
                    return new EntityNotFoundException(errorMsg);
                });

        // TODO: Validate orders is null
        List<OrderCreateDto> orders = payload.orders();
        orders.forEach(order -> {
                    var obtainedFood = foodRepository.findByIdOptional(order.foodId())
                            .orElseThrow(() -> {
                                var foodId = order.foodId();
                                String errorMsg = "Food with Id: %s does not exists.".formatted(foodId);
                                return new EntityNotFoundException(errorMsg);
                            });
                }
        );

        // TODO: I will finish the task


        ticketProducer.publishTicketCreateDto(payload);
        return null;
    }
}
