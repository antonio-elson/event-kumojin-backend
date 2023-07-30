package kumojin.event.api.event;

import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EventRegisterService {
    @Autowired
    private EventRepository eventRepository;

    @Transactional
    public EventDTO schedule (EventRegisterDTO eventRegisterDTO) {
        if(eventRegisterDTO.endDate().isBefore(eventRegisterDTO.startDate())) {
            throw new ValidationException("The end date cannot be less than the start date");
        }

        var event = new Event(null, eventRegisterDTO.name(), eventRegisterDTO.description(), eventRegisterDTO.startDate(), eventRegisterDTO.endDate());
        eventRepository.save(event);

        return new EventDTO(event);
    }
}
