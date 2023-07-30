package kumojin.event.api.event;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Table(name = "events")
@Entity(name = "Event")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ssXXX", timezone = JsonFormat.DEFAULT_TIMEZONE)
    private Instant startDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ssXXX", timezone = JsonFormat.DEFAULT_TIMEZONE)
    private Instant endDate;
    public Event(EventDTO data) {
        this.name = data.title();
        this.description = data.description();
        this.startDate = data.startDate();
        this.endDate = data.endDate();
    }
}
