package org.lievasoft.resource;

import jakarta.validation.Valid;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;
import org.lievasoft.resource.dto.food.FoodCreateDto;
import org.lievasoft.resource.dto.food.PriceUpdateRequest;
import org.lievasoft.service.FoodService;

import java.net.URI;

@Path("/api/v1/foods")
public class FoodResource {

    private final FoodService service;

    public FoodResource(FoodService service) {
        this.service = service;
    }

    @POST
    public Response create(@Valid FoodCreateDto payload) {
        var foodCreateResponse = service.create(payload);
        var uri = URI.create("/api/v1/foods/" + foodCreateResponse.id());
        return Response.created(uri)
                .entity(foodCreateResponse)
                .build();
    }

    @PATCH
    @Path("/{id}/price")
    public Response updatePrice(@PathParam("id") String foodId, @Valid PriceUpdateRequest payload) {
        var priceUpdateResponse = service.changePrice(foodId, payload);
        return Response.ok(priceUpdateResponse).build();
    }
}
