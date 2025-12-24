package org.lievasoft.service;

import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.lievasoft.dto.TicketCreateDto;
import org.lievasoft.dto.TicketCreateResponse;
import org.lievasoft.entity.Waiter;
import org.lievasoft.exception.FoodNotFoundException;
import org.lievasoft.exception.WaiterNotFoundException;
import org.lievasoft.repository.FoodRepository;
import org.lievasoft.repository.WaiterRepository;

@ApplicationScoped
public class TicketService {

    private final TicketServiceClient ticketServiceClient;
    private final WaiterRepository waiterRepository;
    private final FoodRepository foodRepository;

    public TicketService(@RestClient TicketServiceClient ticketServiceClient,
                         WaiterRepository waiterRepository,
                         FoodRepository foodRepository) {
        this.ticketServiceClient = ticketServiceClient;
        this.waiterRepository = waiterRepository;
        this.foodRepository = foodRepository;
    }

    public TicketCreateResponse registerTicket(TicketCreateDto payload) {
        String waiterId = payload.waiterId();
        boolean waiterExists = waiterRepository.exists(waiterId);
        if (waiterExists) {
            var ordersToConvert = payload.orders();
            for (var orderCreateDto : ordersToConvert) {
                var foodId = orderCreateDto.foodId();
                boolean exists = foodRepository.exists(foodId);
                if (!exists) throw new FoodNotFoundException(foodId);
            }
            return ticketServiceClient.createTicket(payload);

        } else throw new WaiterNotFoundException(waiterId);
    }
//            boolean foodExists;
//            for (var orderCreateDto : orderCreateDtos) {
//                foodExists = foodRepository.exists(orderCreateDto.foodId());
//                if (!foodExists) {
//                    String errorMsg = "Food not found for ID: %s".formatted(orderCreateDto.foodId());
//                    throw new EntityNotFoundException(errorMsg);
//                }
//            }
//
//            try {
//                ticketServiceClient.createTicket(payload);
//            } catch (Exception exception) {
//                System.out.println(exception.getMessage());
//            }
//        List<Order> ordersToPersist = new ArrayList<>();
//        payload.orders().forEach(orderCreateDto -> {
//            var obtainedFood = obtainFoodOrElseThrow(orderCreateDto.foodId());
//            var orderToPersist = new Order(obtainedFood, orderCreateDto.quantity(), orderCreateDto.toGo());
//            ordersToPersist.add(orderToPersist);
//            counterService.incrementFood(obtainedFood.getName(), obtainedFood.getProportion(), orderCreateDto.quantity());
//        });
//
//        var obtainedWaiter = obtainWaiterOrElseThrow(payload.waiterId());
//        var ticketToPersist = new Ticket(obtainedWaiter);
//        ticketToPersist.addOrders(ordersToPersist);
//        ticketRepository.create(ticketToPersist);
//        counterService.incrementTicket();

//    public void changeIsPaid(long id, boolean isPaid) {
//        ticketRepository.updateIsPaid(id, isPaid);
//    }

    private Waiter obtainWaiterOrElseThrow(long waiterId) {
        return null;
//        return waiterRepository.findByIdOptional(waiterId)
//                .orElseThrow(() -> {
//                    String errorMsg = "Waiter with Id: %s does not exists.".formatted(waiterId);
//                    return new EntityNotFoundException(errorMsg);
//                });
    }
//
//    private Food obtainFoodOrElseThrow(long foodId) {
//        return foodRepository.findByIdOptional(foodId)
//                .orElseThrow(() -> {
//                    String errorMsg = "Food with Id: %s does not exists.".formatted(foodId);
//                    return new EntityNotFoundException(errorMsg);
//                });
//    }
}
