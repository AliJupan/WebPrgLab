package mk.finki.ukim.mk.lab.service.implementation;

import mk.finki.ukim.mk.lab.model.Event;
import mk.finki.ukim.mk.lab.model.Location;
import mk.finki.ukim.mk.lab.model.exceptions.EventNotFoundException;
import mk.finki.ukim.mk.lab.model.exceptions.LocationNotFoundException;
import mk.finki.ukim.mk.lab.repository.JPA.EventRepository;
import mk.finki.ukim.mk.lab.repository.JPA.LocationRepository;
import mk.finki.ukim.mk.lab.service.EventService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventImp implements EventService {

    private final EventRepository eventRepository;
    private final LocationRepository locationRepository;

    public EventImp(EventRepository eventRepository , LocationRepository locationRepository) {
        this.eventRepository = eventRepository;
        this.locationRepository = locationRepository;
    }

    @Override
    public List<Event> listAll() {
        return eventRepository.findAll();
    }

    @Override
    public List<Event> searchEvents(String text,Long id){
        if(!text.isEmpty()){
            System.out.println("a");
            return eventRepository.findAllByNameLike(text);
        }
        else if(id != null) {
            System.out.println("b");
            return eventRepository.findByLocation_Id(id);
        }
        else
            return eventRepository.findAll();
    }

    @Override
    public List<Event> getEventsByLocation(Long id){
        return eventRepository.findByLocation_Id(id);
    }

    @Override
    public void saveEvent(String name, String description, double popularityScore, Long locationId) {
        Location location = locationRepository.findById(locationId).orElseThrow(() -> new LocationNotFoundException(locationId));

        if(location == null) return;

        eventRepository.save(new Event(name, description, popularityScore, location));
    }

    @Override
    public Event findById(Long eventId) {
        return eventRepository.findById(eventId).orElseThrow(() -> new EventNotFoundException(eventId));
    }

    @Override
    public void updateEvent(Long eventId, String eventName, String description, double popularityScore, Long locationId) {
        Event event = eventRepository.findById(eventId).orElseThrow(() -> new EventNotFoundException(eventId));
        if (event != null) {
            event.setName(eventName);
            event.setDescription(description);
            event.setPopularityScore(popularityScore);
            Location location = locationRepository.findById(locationId).orElseThrow(()->new LocationNotFoundException(locationId));
            event.setLocation(location);

            eventRepository.save(event);
        }
    }

    @Override
    public void deleteEvent(Event event) {
        eventRepository.delete(event);
    }

    @Override
    public void likeEvent(Event event) {
        event.setLiked(true);
        if(event.getPopularityScore() + 0.5 < 5){
            event.setPopularityScore(event.getPopularityScore() + 0.5);
            eventRepository.save(event);
        } else if (event.getPopularityScore() + 0.5 >= 5) {
            event.setPopularityScore(5);
            eventRepository.save(event);
        }
    }
}
