package org.lievasoft.service;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import jakarta.enterprise.context.ApplicationScoped;
import org.lievasoft.dto.FoodResponse;

@ApplicationScoped
public class FoodService {

    private final MeterRegistry meterRegistry;
    private Counter foodRequestsCounter;

    public FoodService(MeterRegistry meterRegistry) {
        this.meterRegistry = meterRegistry;
        initializeMetrics();
    }

    private void initializeMetrics() {
        foodRequestsCounter = Counter.builder("food.api.requests")
                .description("Total number of food requests")
                .tag("endpoint", "/api/v1/food")
                .register(meterRegistry);
    }

    public FoodResponse getFoods() {
        foodRequestsCounter.increment();
        return new FoodResponse(1, "Plancha Entera", 120D);
    }
}
