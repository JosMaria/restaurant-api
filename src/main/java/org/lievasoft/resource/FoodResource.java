package org.lievasoft.resource;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import org.lievasoft.service.FoodService;

@Path("/api/v1/food")
public class FoodResource {

    private final FoodService service;

    public FoodResource(FoodService service) {
        this.service = service;
    }

    @GET
    public Response get() {
        var payloadResponse = service.getFoods();
        return Response.ok(payloadResponse).build();
    }
}
