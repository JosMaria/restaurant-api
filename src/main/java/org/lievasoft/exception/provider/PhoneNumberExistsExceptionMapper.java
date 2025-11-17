package org.lievasoft.exception.provider;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import org.lievasoft.exception.ErrorResponse;
import org.lievasoft.exception.PhoneNumberExistsException;

import java.time.LocalDateTime;

import static io.netty.handler.codec.http.HttpResponseStatus.CONFLICT;

@Provider
public class PhoneNumberExistsExceptionMapper implements ExceptionMapper<PhoneNumberExistsException> {

    @Override
    public Response toResponse(PhoneNumberExistsException e) {
        var errorResponse = new ErrorResponse(
                "PHONE_EXISTS",
                e.getMessage(),
                CONFLICT.code(),
                LocalDateTime.now()
        );

        return Response.status(errorResponse.statusCode())
                .entity(errorResponse)
                .build();
    }
}
