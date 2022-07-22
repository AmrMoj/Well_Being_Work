package tn.esprit.wellbeingwork.service;

import tn.esprit.wellbeingwork.entity.Event;

import java.util.List;

/**
 * @author amoujbani on 7/19/2022
 * @project WellBeingWork
 */

public interface EventService {
    List<Event> getEvents();

    Event addEvent(Event event);

    Event getEvent(Long id);

    void deleteEvent(Long id);

    Event updateEvent(Event event);


}
