package org.lievasoft.service;

import jakarta.enterprise.context.ApplicationScoped;
import org.lievasoft.dto.TicketCreateDto;
import org.lievasoft.dto.TicketResponse;
import org.lievasoft.kafka.producer.TicketProducer;
import org.lievasoft.repository.TicketRepository;

@ApplicationScoped
public class TicketService {

    private final TicketProducer ticketProducer;

    public TicketService(TicketProducer ticketProducer) {
        this.ticketProducer = ticketProducer;
    }

    public TicketResponse registerTicket(TicketCreateDto payload) {
        ticketProducer.publishTicketCreateDto(payload);
        return null;
    }
}
