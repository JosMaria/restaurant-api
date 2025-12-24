package org.lievasoft.service;

import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.lievasoft.dto.TicketCreateDto;
import org.lievasoft.dto.TicketCreateResponse;

@Path("/api/v1/tickets")
@RegisterRestClient(configKey = "ticket-service-api")
public interface TicketServiceClient {

    @POST
    TicketCreateResponse createTicket(TicketCreateDto payload);
}
