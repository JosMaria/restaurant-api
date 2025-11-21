package org.lievasoft.resource;

import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import org.lievasoft.dto.TicketCreateDto;
import org.lievasoft.service.TicketService;

import java.net.URI;

@Path("/api/v1/tickets")
public class TicketResource {

    private final TicketService service;

    public TicketResource(TicketService ticketService) {
        this.service = ticketService;
    }

    @POST
    public Response create(TicketCreateDto payload) {
        var ticketResponse = service.registerTicket(payload);
        return Response.created(URI.create("/api/v1/tickets"))
                .entity(ticketResponse)
                .build();
    }

}
