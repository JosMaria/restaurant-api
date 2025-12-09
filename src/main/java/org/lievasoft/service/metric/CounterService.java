package org.lievasoft.service.metric;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Tags;
import jakarta.enterprise.context.ApplicationScoped;
import org.lievasoft.enums.Proportion;

@ApplicationScoped
public class CounterService {

    private final MeterRegistry registry;
    private final Tags commonTags;

    public CounterService(MeterRegistry registry) {
        commonTags = Tags.of("app", "restaurant").and("version", "1.0.0");
        this.registry = registry;
    }

    public void incrementTicket() {
        registry.counter("ticket.created", commonTags).increment();
    }

    public void incrementFood(String name, Proportion proportion, int count) {
        var tags = Tags.of("food", name).and("proportion", proportion.name());
        registry.counter("food.created", commonTags.and(tags)).increment(count);
    }
}
