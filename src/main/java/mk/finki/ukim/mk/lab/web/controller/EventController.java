package mk.finki.ukim.mk.lab.web.controller;

import mk.finki.ukim.mk.lab.model.Event;
import mk.finki.ukim.mk.lab.service.EventService;
import mk.finki.ukim.mk.lab.service.LocationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/events")
public class EventController {

    private final EventService eventService;
    private final LocationService locationService;

    @Autowired
    public EventController(EventService eventService, LocationService locationService) {
        this.eventService = eventService;
        this.locationService = locationService;
    }

    @GetMapping
    public String getEventsPage(@RequestParam(required = false) String error, Model model) {
        System.out.println("a");
        model.addAttribute("events", eventService.listAll());
        model.addAttribute("locations", locationService.findAll());
        model.addAttribute("error", error);
        return "listEvents";
    }

//    @PostMapping("/search")
//    public String searchEvents(@RequestParam String searchText, Model model) {
//        System.out.println("b");
//        if (searchText == null || searchText.isEmpty()) {model.addAttribute("events", eventService.listAll());
//                model.addAttribute("locations", locationService.findAll());
//            return "listEvents";}
//        var filteredEvents = eventService.searchEvents(searchText);
//
//        model.addAttribute("events", filteredEvents);
//        model.addAttribute("searchText", searchText);
//
//        return "listEvents";
//    }

    @PostMapping("/search")
    public String searchEvents(@RequestParam(required = false) String searchText,
                               @RequestParam(required = false) Long locationId,
                               Model model) {

        model.addAttribute("locations", locationService.findAll());

        var filteredEvents = eventService.searchEvents(searchText,locationId);

        model.addAttribute("events", filteredEvents);
        model.addAttribute("searchText", searchText);
        model.addAttribute("selectedLocationId", locationId);

        return "listEvents";  // Return to the listEvents view
    }

//    @PostMapping("/location")
//    public String getEventsByLocation(@RequestParam("locationId") Long id, Model model) {
//        // Fetch events by location
//        var filteredEvents = eventService.getEventsByLocation(id);
//
//        // Add the filtered events and location ID to the model
//        model.addAttribute("events", filteredEvents);
//        model.addAttribute("searchText", id);
//
//        // Return the same view to show the filtered events
//        return "listEvents";
//    }


    @PostMapping("/delete/{id}")
    public String deleteEvent(@PathVariable Long id) {
        Event event = eventService.findById(id);
        eventService.deleteEvent(event);

        return "redirect:/events";
    }

    @PostMapping("/like/{id}")
    public String likeEvent(@PathVariable Long id) {
        Event event = eventService.findById(id);
        eventService.likeEvent(event);

        return "redirect:/events";
    }

    @GetMapping("/edit/{id}")
    public String showEditEventForm(@PathVariable Long id, Model model) {
        Event event = eventService.findById(id);
        if (event != null) {
            model.addAttribute("event", event);
            model.addAttribute("locations", locationService.findAll());
            return "addEvent";
        }
        return "redirect:/events";
    }

    @GetMapping("/add")
    public String getAddEventPage(Model model) {
        model.addAttribute("locations", locationService.findAll());
        return "addEvent";
    }

    @PostMapping("/add")
    public String saveEvent(@RequestParam String name,
                            @RequestParam String description,
                            @RequestParam double popularityScore,
                            @RequestParam Long locationId,
                            @RequestParam(required = false) Long event) {

        if(event == null) {
            eventService.saveEvent(name, description, popularityScore, locationId);
        }
        else
        {
            eventService.updateEvent(event,name, description, popularityScore, locationId);
        }

        return "redirect:/events";
    }

}
