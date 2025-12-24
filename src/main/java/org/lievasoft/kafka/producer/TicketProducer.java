package org.lievasoft.kafka.producer;

import jakarta.enterprise.context.ApplicationScoped;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.lievasoft.dto.TicketCreateDto;

import java.util.UUID;

@ApplicationScoped
public class TicketProducer {

    private final Producer<String, TicketCreateDto> kafkaProducer;

    public TicketProducer(Producer<String, TicketCreateDto> kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    public void publishTicketCreateDto(TicketCreateDto dto) {
        var record = new ProducerRecord<>("ticket___events", UUID.randomUUID().toString(), dto);
        kafkaProducer.send(record);
    }
}
