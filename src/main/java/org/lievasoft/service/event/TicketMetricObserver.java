package org.lievasoft.service.event;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;

@ApplicationScoped
public class TicketMetricObserver {

    private final MeterRegistry meterRegistry;

    private Counter totalTicketCounter;

    public TicketMetricObserver(MeterRegistry meterRegistry) {
        this.meterRegistry = meterRegistry;
    }

    @PostConstruct
    void init() {
        totalTicketCounter = Counter.builder("restaurant.tickets.created")
                .description("Total tickets created")
                .register(meterRegistry);
    }

    public void onTicketCreated(@Observes TicketCreatedEvent event) {
        totalTicketCounter.increment();
    }
}
