package org.lievasoft.resource;

import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import org.lievasoft.dto.WaiterCreateDto;
import org.lievasoft.service.WaiterService;

import java.net.URI;

@Path("/api/v1/waiters")
public class WaiterResource {

    private final WaiterService service;

    public WaiterResource(WaiterService service) {
        this.service = service;
    }

    @POST
    public Response create(WaiterCreateDto payload) {
        var response = service.create(payload);
        return Response.created(URI.create("/api/v1/waiters"))
                .entity(response)
                .build();
    }
}
