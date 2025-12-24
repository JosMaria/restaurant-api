package org.lievasoft.exception.provider;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import org.lievasoft.exception.ErrorResponse;
import org.lievasoft.exception.FoodNotFoundException;

import java.time.LocalDateTime;

import static io.netty.handler.codec.http.HttpResponseStatus.BAD_REQUEST;

@Provider
public class FoodNotFoundExceptionMapper implements ExceptionMapper<FoodNotFoundException> {

    @Override
    public Response toResponse(FoodNotFoundException e) {
        var errorResponse = new ErrorResponse(
                "FOOD_NOT_FOUND",
                e.getMessage(),
                BAD_REQUEST.code(),
                LocalDateTime.now()
        );

        return Response.status(errorResponse.statusCode())
                .entity(errorResponse)
                .build();
    }
}
