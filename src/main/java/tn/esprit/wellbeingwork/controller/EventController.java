package tn.esprit.wellbeingwork.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.wellbeingwork.entity.Event;
import tn.esprit.wellbeingwork.service.EventService;

import java.util.List;

/**
 * @author amoujbani on 7/19/2022
 * @project WellBeingWork
 */
@RestController
@RequestMapping("Event")
@Api(tags = "Event management")
public class EventController {

    @Autowired
    EventService eventService;

    @ApiOperation(value="Add new event")
    @PostMapping("addEvent")
    public Event addEvent (@RequestBody Event event){
        return eventService.addEvent(event);
    }

    @ApiOperation(value ="Get all events")
    @GetMapping("getEvents")
    public List<Event> getAllEvents(){
        return eventService.getEvents();
    }

    @ApiOperation(value = "Get event by ID")
    @GetMapping("/getEvent/{event-id}")
    public Event getEvent(@PathVariable("event-id") long id){
        return eventService.getEvent(id);
    }

    @ApiOperation(value = "Delete an event")
    @DeleteMapping("deleteEvent/{event-id}")
    public void deleteEvent(@PathVariable("event-id") long id){
        eventService.deleteEvent(id);
    }

    @ApiOperation(value = "Update an event")
    @PutMapping("updateEvent")
    public Event updateEvent(@RequestBody Event event){
        return eventService.updateEvent(event);
    }

}
