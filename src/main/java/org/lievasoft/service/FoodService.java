package org.lievasoft.service;

import jakarta.enterprise.context.ApplicationScoped;
import org.lievasoft.resource.dto.food.FoodCreateDto;
import org.lievasoft.resource.dto.food.FoodCreateResponse;
import org.lievasoft.resource.dto.food.PriceUpdateRequest;
import org.lievasoft.entity.Food;
import org.lievasoft.exception.FoodExistsException;
import org.lievasoft.repository.FoodRepository;
import org.lievasoft.resource.dto.food.PriceUpdateResponse;

@ApplicationScoped
public class FoodService {

    private final FoodRepository foodRepository;

    public FoodService(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    public FoodCreateResponse create(FoodCreateDto payload) {
        if (!foodRepository.exists(payload.name(), payload.proportion())) {
            var foodToPersist = mapToFood(payload);
            foodRepository.create(foodToPersist);
            return mapToFoodResponse(foodToPersist);

        } else throw new FoodExistsException(payload.name(), payload.proportion());
    }

    public PriceUpdateResponse changePrice(String foodId, PriceUpdateRequest payload) {
        var updatedFood = foodRepository.updatePrice(foodId, payload.price());
        return mapToPriceUpdateResponse(updatedFood);
    }

    private Food mapToFood(FoodCreateDto dto) {
        return new Food(dto.name(), dto.proportion(), dto.price());
    }

    private FoodCreateResponse mapToFoodResponse(Food food) {
        return new FoodCreateResponse(food.getId(), food.getName(), food.getProportion(), food.getPrice());
    }

    private PriceUpdateResponse mapToPriceUpdateResponse(Food food) {
        return new PriceUpdateResponse(food.getId(), food.getPrice());
    }
}
