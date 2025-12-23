package org.lievasoft.service;

import jakarta.enterprise.context.ApplicationScoped;
import org.lievasoft.exception.FoodExistsException;
import org.lievasoft.mapper.FoodMapper;
import org.lievasoft.repository.FoodRepository;
import org.lievasoft.resource.dto.food.FoodCreateDto;
import org.lievasoft.resource.dto.food.FoodCreateResponse;
import org.lievasoft.resource.dto.food.PriceUpdateRequest;
import org.lievasoft.resource.dto.food.PriceUpdateResponse;

@ApplicationScoped
public class FoodService {

    private final FoodRepository foodRepository;
    private final FoodMapper foodMapper;

    public FoodService(FoodRepository foodRepository, FoodMapper foodMapper) {
        this.foodRepository = foodRepository;
        this.foodMapper = foodMapper;
    }

    public FoodCreateResponse create(FoodCreateDto payload) {
        if (!foodRepository.exists(payload.name(), payload.proportion())) {
            var foodToPersist = foodMapper.toEntity(payload);
            foodRepository.create(foodToPersist);
            return foodMapper.toFoodCreateResponse(foodToPersist);

        } else throw new FoodExistsException(payload.name(), payload.proportion());
    }

    public PriceUpdateResponse changePrice(String foodId, PriceUpdateRequest payload) {
        var updatedFood = foodRepository.updatePrice(foodId, payload.price());
        return foodMapper.toPriceUpdateResponse(updatedFood);
    }
}
