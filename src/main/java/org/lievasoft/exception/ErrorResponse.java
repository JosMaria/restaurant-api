package org.lievasoft.exception;

import java.time.LocalDateTime;

public record ErrorResponse(
        String reason,
        String message,
        int statusCode,
        LocalDateTime localDateTime
) {
}
