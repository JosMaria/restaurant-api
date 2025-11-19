package org.lievasoft.service;

import jakarta.enterprise.context.ApplicationScoped;
import org.lievasoft.dto.TicketCreateDto;
import org.lievasoft.dto.TicketResponse;
import org.lievasoft.repository.TicketRepository;

@ApplicationScoped
public class TicketService {

    private final TicketRepository ticketRepository;

    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public TicketResponse registerTicket(TicketCreateDto payload) {
        return null;
    }
}
