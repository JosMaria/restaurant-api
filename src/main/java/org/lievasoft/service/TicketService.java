package org.lievasoft.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityNotFoundException;
import org.lievasoft.dto.TicketCreateDto;
import org.lievasoft.dto.TicketResponse;
import org.lievasoft.entity.Food;
import org.lievasoft.entity.Order;
import org.lievasoft.entity.Ticket;
import org.lievasoft.entity.Waiter;
import org.lievasoft.kafka.producer.TicketProducer;
import org.lievasoft.repository.FoodRepository;
import org.lievasoft.repository.TicketRepository;
import org.lievasoft.repository.WaiterRepository;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class TicketService {

    private final FoodRepository foodRepository;
    private final WaiterRepository waiterRepository;
    private final TicketRepository ticketRepository;
    private final TicketProducer ticketProducer;

    public TicketService(TicketProducer ticketProducer, WaiterRepository waiterRepository,
                         FoodRepository foodRepository, TicketRepository ticketRepository) {
        this.ticketProducer = ticketProducer;
        this.waiterRepository = waiterRepository;
        this.foodRepository = foodRepository;
        this.ticketRepository = ticketRepository;
    }

    public TicketResponse registerTicketV2(TicketCreateDto payload) {
        List<Order> ordersToPersist = new ArrayList<>();
        payload.orders().forEach(orderCreateDto -> {
            var obtainedFood = obtainFoodOrElseThrow(orderCreateDto.foodId());
            var orderToPersist = new Order(obtainedFood, orderCreateDto.quantity(), orderCreateDto.toGo());
            ordersToPersist.add(orderToPersist);
        });

        var obtainedWaiter = obtainWaiterOrElseThrow(payload.waiterId());
        var ticketToPersist = new Ticket(obtainedWaiter);
        ticketToPersist.addOrders(ordersToPersist);
        ticketRepository.create(ticketToPersist);
        return null;
    }

    private Waiter obtainWaiterOrElseThrow(long waiterId) {
        return waiterRepository.findByIdOptional(waiterId)
                .orElseThrow(() -> {
                    String errorMsg = "Waiter with Id: %s does not exists.".formatted(waiterId);
                    return new EntityNotFoundException(errorMsg);
                });
    }

    private Food obtainFoodOrElseThrow(long foodId) {
        return foodRepository.findByIdOptional(foodId)
                .orElseThrow(() -> {
                    String errorMsg = "Food with Id: %s does not exists.".formatted(foodId);
                    return new EntityNotFoundException(errorMsg);
                });
    }
}
