package events.infra.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Error response")
public record ErrorResponseDto(
        @Schema(description = "Error message", example = "User with this email already exists")
        String message,

        @Schema(description = "HTTP status code", example = "409")
        int status
) {
}
