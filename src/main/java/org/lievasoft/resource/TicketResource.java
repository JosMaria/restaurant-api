package org.lievasoft.resource;

import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import org.jboss.resteasy.reactive.RestQuery;
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
    public Response create(@Valid TicketCreateDto payload) {
        var ticketResponse = service.registerTicket(payload);
        return Response.created(URI.create("/api/v1/tickets"))
                .entity(ticketResponse)
                .build();
    }

    @PATCH
    @Path("/{id}/paid")
    public Response changeIsPaid(@PathParam("id") Long id, @RestQuery boolean isPaid) {
//        service.changeIsPaid(id, isPaid);
        return Response.ok().build();
    }
}
