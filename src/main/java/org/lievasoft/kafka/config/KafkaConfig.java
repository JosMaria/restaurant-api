package org.lievasoft.kafka.config;

import io.quarkus.kafka.client.serialization.ObjectMapperSerializer;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.lievasoft.dto.TicketCreateDto;

import java.util.Properties;

@ApplicationScoped
public class KafkaConfig {

    @ConfigProperty(name = "kafka.bootstrap.servers")
    String bootstrapServers;

    @ConfigProperty(name = "kafka.producer.retries", defaultValue = "3")
    String retries;

    @Produces
    @ApplicationScoped
    public Producer<String, TicketCreateDto> createKafkaProducer() {
        var properties = new Properties();
        properties.put("bootstrap.servers", bootstrapServers);
        properties.put("key.serializer", StringSerializer.class.getName());
        properties.put("value.serializer", ObjectMapperSerializer.class.getName());
        properties.put("retries", Integer.parseInt(retries));
        properties.put("enable.idempotence", true);
        return new KafkaProducer<>(properties);
    }
}
