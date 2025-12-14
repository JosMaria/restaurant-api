package org.lievasoft.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record WaiterCreateDto(
        @NotBlank(message = "Name must not be null, empty or blank")
        String name,

        @NotBlank(message = "Lastname must not be null, empty or blank")
        String lastname,

        @Pattern(regexp = "^\\d{8}$", message = "PhoneNumber must contain exactly 8 digits")
        String phoneNumber
) {
}
