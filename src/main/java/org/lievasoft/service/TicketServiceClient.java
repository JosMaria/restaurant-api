package org.lievasoft.service;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.lievasoft.dto.TicketCreateDto;

@Path("/api/v1/tickets")
@RegisterRestClient(configKey = "ticket-service-api")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface TicketServiceClient {

    @POST
    Response createTicket(TicketCreateDto payload);
}
