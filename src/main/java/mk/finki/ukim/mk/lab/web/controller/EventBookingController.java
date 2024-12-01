package mk.finki.ukim.mk.lab.web.controller;


import jakarta.servlet.http.HttpServletRequest;
import mk.finki.ukim.mk.lab.model.Event;
import mk.finki.ukim.mk.lab.model.EventBooking;
import mk.finki.ukim.mk.lab.model.exceptions.EventNotFoundException;
import mk.finki.ukim.mk.lab.service.EventBookingService;
import mk.finki.ukim.mk.lab.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.List;

@Controller
@RequestMapping("/eventsBookings")
public class EventBookingController {

    private final EventBookingService eventBookingService;
    private final EventService eventService;

    @Autowired
    public EventBookingController(EventBookingService eventBookingService, EventService eventService) {
        this.eventBookingService = eventBookingService;
        this.eventService = eventService;
    }

    @PostMapping("/book")
    public String placeBooking(@RequestParam String selectedEventId,
                               @RequestParam String attendeeName,
                               @RequestParam int numTickets,
                               HttpServletRequest request,
                               Model model) {

        Event event = eventService.findById(Long.valueOf(selectedEventId));
        String attendeeAddress = request.getRemoteAddr();

        eventBookingService.placeBooking(event.getName(), attendeeName, attendeeAddress, numTickets);

        List<EventBooking> bookings = eventBookingService.listAll();
        model.addAttribute("bookings", bookings);

        return "bookingConfirmation";
    }

    @GetMapping
    public String searchBookings(@RequestParam(required = false) String searchText, Model model) {
        List<EventBooking> bookings;

        if (searchText != null && !searchText.isEmpty()) {
            bookings = eventBookingService.searchEvents(searchText);
        } else {
            bookings = eventBookingService.listAll();
        }

        model.addAttribute("bookings", bookings);

        return "bookingConfirmation";
    }
}
