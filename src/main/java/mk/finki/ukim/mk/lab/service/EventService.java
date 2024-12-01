package mk.finki.ukim.mk.lab.service;

import mk.finki.ukim.mk.lab.model.Event;

import java.util.List;

public interface EventService {
    List<Event> listAll();
    List<Event> searchEvents(String text,Long id);
    public void saveEvent(String name, String description, double popularityScore, Long locationId);
    Event findById(Long eventId);
    void updateEvent(Long eventId, String eventName, String description, double popularityScore, Long locationId);
    void deleteEvent(Event event);
    void likeEvent(Event event);
    List<Event> getEventsByLocation(Long id);
}
