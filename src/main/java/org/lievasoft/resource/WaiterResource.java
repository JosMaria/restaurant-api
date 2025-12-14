package org.lievasoft.resource;

import jakarta.validation.Valid;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import org.lievasoft.dto.WaiterCreateDto;
import org.lievasoft.dto.WaiterCreateResponse;
import org.lievasoft.service.WaiterService;

import java.net.URI;

@Path("/api/v1/waiters")
public class WaiterResource {

    private final WaiterService service;

    public WaiterResource(WaiterService service) {
        this.service = service;
    }

    @POST
    public Response create(@Valid WaiterCreateDto payload) {
        var waiterCreateResponse = service.create(payload);
        var uri = URI.create("/api/v1/waiters/" + waiterCreateResponse.id());
        return Response.created(uri)
                .entity(waiterCreateResponse)
                .build();
    }
}
