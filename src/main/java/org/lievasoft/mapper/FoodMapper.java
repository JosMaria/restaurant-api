package org.lievasoft.mapper;

import jakarta.enterprise.context.ApplicationScoped;
import org.lievasoft.entity.Food;
import org.lievasoft.resource.dto.food.FoodCreateDto;
import org.lievasoft.resource.dto.food.FoodCreateResponse;
import org.lievasoft.resource.dto.food.PriceUpdateResponse;

@ApplicationScoped
public class FoodMapper {

    public Food toEntity(FoodCreateDto dto) {
        return new Food(dto.name(), dto.proportion(), dto.price());
    }

    public FoodCreateResponse toFoodCreateResponse(Food food) {
        return new FoodCreateResponse(food.getId(), food.getName(), food.getProportion(), food.getPrice());
    }

    public PriceUpdateResponse toPriceUpdateResponse(Food food) {
        return new PriceUpdateResponse(food.getId(), food.getPrice());
    }
}
