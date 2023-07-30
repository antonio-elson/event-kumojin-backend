package kumojin.event.api.event;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/events")
public class EventController {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private EventRegisterService eventRegisterService;

    @PostMapping
    @Transactional
    public ResponseEntity register(@RequestBody @Valid EventRegisterDTO eventRegisterDTO) {
        var dto =  eventRegisterService.schedule(eventRegisterDTO);
        return  ResponseEntity.ok(dto);
    }

}
