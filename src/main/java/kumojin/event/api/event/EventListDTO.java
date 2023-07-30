package kumojin.event.api.event;

import java.time.LocalDateTime;

public record EventListDTO(long id, String name, String description, LocalDateTime startDate, LocalDateTime endDate) {
    public EventListDTO(Event event, LocalDateTime startDate, LocalDateTime endDate) {
        this(event.getId(), event.getName(), event.getDescription(), startDate, endDate);
    }
}
