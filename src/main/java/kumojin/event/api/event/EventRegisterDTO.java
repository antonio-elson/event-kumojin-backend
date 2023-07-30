package kumojin.event.api.event;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.Instant;

public record EventRegisterDTO(
        @NotBlank
        String name,
        String description,
        @NotNull
        @Future
        Instant startDate,
        @NotNull
        @Future
        Instant endDate) {
}
