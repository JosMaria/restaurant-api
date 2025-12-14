package org.lievasoft.service;

import jakarta.enterprise.context.ApplicationScoped;
import org.lievasoft.dto.FoodCreateDto;
import org.lievasoft.dto.FoodCreateResponse;
import org.lievasoft.dto.PriceUpdateRequest;
import org.lievasoft.entity.Food;
import org.lievasoft.exception.FoodExistsException;
import org.lievasoft.repository.FoodRepository;

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

    private Food mapToFood(FoodCreateDto dto) {
        return new Food(dto.name(), dto.proportion(), dto.price());
    }

    private FoodCreateResponse mapToFoodResponse(Food food) {
        return new FoodCreateResponse(food.getId(), food.getName(), food.getProportion(), food.getPrice());
    }

    public FoodCreateResponse changePrice(Long foodId, PriceUpdateRequest payload) {
        var updatedFood = foodRepository.updatePrice(foodId, payload.price());
        return mapToFoodResponse(updatedFood);
    }
}
