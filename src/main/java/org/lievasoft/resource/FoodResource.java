package org.lievasoft.resource;

import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;
import org.lievasoft.dto.FoodCreateDto;
import org.lievasoft.dto.PriceUpdateRequest;
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

    @PATCH
    @Path("/{id}/price")
    public Response updatePrice(@PathParam("id") Long foodId, PriceUpdateRequest payload) {
        var response = service.changePrice(foodId, payload);
        return Response.ok(response).build();
    }
}
