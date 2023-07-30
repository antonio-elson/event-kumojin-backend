package kumojin.event.api.event;

import java.time.Instant;

public record EventDTO(long id, String name, String description, Instant startDate, Instant endDate) {
    public EventDTO (Event event) {
        this(event.getId(), event.getName(), event.getDescription(), event.getStartDate(), event.getStartDate());
    }
}
