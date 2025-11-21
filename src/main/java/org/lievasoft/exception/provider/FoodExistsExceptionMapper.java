package org.lievasoft.exception.provider;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import org.lievasoft.exception.ErrorResponse;
import org.lievasoft.exception.FoodExistsException;

import java.time.LocalDateTime;

import static io.netty.handler.codec.http.HttpResponseStatus.CONFLICT;

@Provider
public class FoodExistsExceptionMapper implements ExceptionMapper<FoodExistsException> {

    @Override
    public Response toResponse(FoodExistsException e) {
        var errorResponse = new ErrorResponse(
                "FOOD_EXISTS",
                e.getMessage(),
                CONFLICT.code(),
                LocalDateTime.now()
        );

        return Response.status(errorResponse.statusCode())
                .entity(errorResponse)
                .build();
    }
}
