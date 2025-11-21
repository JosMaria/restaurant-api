package org.lievasoft.resource;

import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import org.lievasoft.dto.FoodCreateDto;
import org.lievasoft.service.FoodService;

import java.net.URI;

@Path("/api/v1/foods")
public class FoodResource {

    private final FoodService service;

    public FoodResource(FoodService service) {
        this.service = service;
    }

    @POST
    public Response create(FoodCreateDto payload) {
        var response = service.create(payload);
        return Response.created(URI.create("/api/v1/foods"))
                .entity(response)
                .build();
    }
}
