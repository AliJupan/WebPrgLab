package mk.finki.ukim.mk.lab.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.finki.ukim.mk.lab.model.Event;
import mk.finki.ukim.mk.lab.model.Location;
import mk.finki.ukim.mk.lab.repository.JPA.EventRepository;
import mk.finki.ukim.mk.lab.repository.JPA.LocationRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {

    public static List<Event> events = null;
    public static List<Location> locations = null;

    private final EventRepository eventRepo;
    private final LocationRepository locationRepo;

    public DataHolder(EventRepository eventRepo, LocationRepository locationRepo) {
        this.eventRepo = eventRepo;
        this.locationRepo = locationRepo;
    }

    @PostConstruct
    public void init(){
        locations = new ArrayList<>();
        if(locationRepo.count() == 0){
            locations.add(new Location("Central Park", 500, "123 Main St", "Open-air event space in the city center"));
            locations.add(new Location("Art Gallery", 150, "456 Elm St", "Indoor gallery for art exhibitions"));
            locations.add(new Location("The Grand Theater", 300, "789 Oak St", "Classic theater for live performances"));
            locations.add(new Location("Gourmet Plaza", 250, "101 Maple Ave", "Outdoor space for food and cultural events"));
            locations.add(new Location("Tech Arena", 1000, "202 Pine Ave", "Large venue for tech conferences and expos"));
        }

        this.locationRepo.saveAll(locations);

        events = new ArrayList<>();
        if(eventRepo.count() == 0){
            events.add(new Event("Concert A", "Music Event", 4.5, locations.get(0)));
            events.add(new Event("Festival B", "Cultural Event", 4.0, locations.get(1)));
            events.add(new Event("Conference C", "Tech Event", 5.0, locations.get(2)));
            events.add(new Event("Workshop D", "Educational Event", 4.8, locations.get(3)));
            events.add(new Event("Webinar E", "Online Event", 3.9, locations.get(4)));

            events.add(new Event("Meetup F", "Networking Event", 4.7, locations.get(0)));
            events.add(new Event("Seminar G", "Business Event", 4.1, locations.get(1)));
            events.add(new Event("Hackathon H", "Programming Event", 5.0, locations.get(2)));
            events.add(new Event("Charity I", "Fundraising Event", 4.6, locations.get(3)));
            events.add(new Event("Exhibition J", "Art Event", 4.3, locations.get(4)));
        }

        this.eventRepo.saveAll(events);
    }
}
