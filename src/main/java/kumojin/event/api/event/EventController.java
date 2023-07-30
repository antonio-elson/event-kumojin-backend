package kumojin.event.api.event;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.ZoneId;

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


    @GetMapping
    public Page<EventListDTO> listEvents(@PageableDefault(size = 10, sort = {"startDate"}, direction = Sort.Direction.DESC) Pageable pagination, @RequestHeader(value = "zone") String zone) {
        return eventRepository.findAll(pagination).map(r -> setZoneDate(r,zone));
    }

    private EventListDTO setZoneDate(Event event, String zone) {
        System.out.println(zone);
        LocalDateTime startDate = event.getStartDate()
                .atZone(ZoneId.of(zone))
                .toLocalDateTime();
        LocalDateTime endDate = event.getEndDate()
                .atZone(ZoneId.of(zone))
                .toLocalDateTime();
        return new EventListDTO(event, startDate, endDate);
    }

}
