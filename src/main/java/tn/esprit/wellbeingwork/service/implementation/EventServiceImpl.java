package tn.esprit.wellbeingwork.service.implementation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import tn.esprit.wellbeingwork.controller.exception.NoDataFoundException;
import tn.esprit.wellbeingwork.entity.Event;
import tn.esprit.wellbeingwork.repository.EventRepository;
import tn.esprit.wellbeingwork.service.EventService;

import java.util.List;

/**
 * @author amoujbani on 7/19/2022
 * @project WellBeingWork
 */
@Service
@Slf4j
public class EventServiceImpl implements EventService {

    @Autowired
    EventRepository eventRepository;

    @Override
    public List<Event> getEvents() {
        List<Event> eventList= eventRepository.findAll();
        for (Event event: eventList){
            log.info("Event: "+event);
        }
        return eventList;
    }

    @Override
    public Event addEvent(Event event){
        log.info("Adding event: "+ event.getEventName());
        return eventRepository.save(event);
    }

    @Override
    public Event getEvent(Long id) {
return null;
       // return eventRepository.findById(id).orElseThrow(NoDataFoundException::new);
    }

    @Override
    public void deleteEvent(Long id) {
        Event event=eventRepository.findById(id).orElse(null);
        assert event != null;
        log.info("Deleting event: "+event.getEventName());
        eventRepository.deleteById(id);

    }

    @Override
    public Event updateEvent(Event event) {
        log.info("Updating event: "+event);
        return eventRepository.save(event);
    }


}
