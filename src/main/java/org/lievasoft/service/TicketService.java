package org.lievasoft.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
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

    @Transactional
    public TicketResponse registerTicket(TicketCreateDto payload) {
        var orderCreateDtos = payload.orders();
        if (!orderCreateDtos.isEmpty()) {
            var obtainedWaiter = getWaiterOrElseThrow(payload.waiterId());
            var ticket = new Ticket(obtainedWaiter);
            List<Order> ordersToPersist = new ArrayList<>();
            orderCreateDtos.forEach(orderCreateDto -> {
                var obtainedFood = getFoodOrElseThrow(orderCreateDto.foodId());
                var orderToPersist = new Order(orderCreateDto.quantity(), orderCreateDto.toGo());
                orderToPersist.setFood(obtainedFood);
                ordersToPersist.add(orderToPersist);
            });
            ticket.addOrders(ordersToPersist);
            ticketRepository.persist(ticket);
        }
        //ticketProducer.publishTicketCreateDto(payload);
        return null;
    }

    private Waiter getWaiterOrElseThrow(long waiterId) {
        return waiterRepository.findByIdOptional(waiterId)
                .orElseThrow(() -> {
                    String errorMsg = "Waiter with Id: %s does not exists.".formatted(waiterId);
                    return new EntityNotFoundException(errorMsg);
                });
    }

    private Food getFoodOrElseThrow(long foodId) {
        return foodRepository.findByIdOptional(foodId)
                .orElseThrow(() -> {
                    String errorMsg = "Food with Id: %s does not exists.".formatted(foodId);
                    return new EntityNotFoundException(errorMsg);
                });
    }
}
