package org.lievasoft.service;

import jakarta.enterprise.context.ApplicationScoped;
import org.lievasoft.dto.FoodResponse;

@ApplicationScoped
public class FoodService {

    public FoodResponse getFoods() {
        return new FoodResponse(1, "Plancha Entera", 120D);
    }
}
