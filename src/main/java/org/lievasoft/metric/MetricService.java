package org.lievasoft.metric;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;

import java.time.Duration;

@ApplicationScoped
public class MetricService {

    private final MeterRegistry registry;
    private Timer timer;

    public MetricService(MeterRegistry registry) {
        this.registry = registry;
    }

    @PostConstruct
    void init() {
        timer = Timer.builder("database.insert.operation")
                .description("Time taken to insert records into database")
                .tag("operation", "insert")
                .tag("database", "restaurant_db")
                .publishPercentiles(0.6, 0.95, 0.99)
                .publishPercentileHistogram()
                .distributionStatisticExpiry(Duration.ofMinutes(10))
                .sla(
                        Duration.ofMillis(10),
                        Duration.ofMillis(50),
                        Duration.ofMillis(100),
                        Duration.ofMillis(500),
                        Duration.ofSeconds(1)
                )
                .register(registry);
    }

    public void measureInsert(Runnable insertOperation) {
        Timer.Sample sample = Timer.start(registry);
        try {
            insertOperation.run();

        } finally {
            sample.stop(timer);
        }
    }
}
