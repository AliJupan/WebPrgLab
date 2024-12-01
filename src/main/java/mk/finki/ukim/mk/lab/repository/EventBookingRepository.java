package mk.finki.ukim.mk.lab.repository;

import mk.finki.ukim.mk.lab.model.Event;
import mk.finki.ukim.mk.lab.model.EventBooking;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EventBookingRepository {

    private final List<EventBooking> events;

    public EventBookingRepository(List<EventBooking> events) {
        this.events = events;
    }

    public EventBooking save(EventBooking event) {
        events.add(event);

        return event;
    }

    public List<EventBooking> findAll() {
        return events;
    }

    public List<EventBooking> searchEvents(String text) {
        return events.stream()
                .filter(event -> (event.getEventName().toLowerCase().contains(text.toLowerCase()) ||
                        event.getAttendeeName().toLowerCase().contains(text.toLowerCase())))
                .toList();
    }
}
