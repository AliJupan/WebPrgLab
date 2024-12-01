//package mk.finki.ukim.mk.lab.repository;
//
//import mk.finki.ukim.mk.lab.model.Event;
//import mk.finki.ukim.mk.lab.model.Location;
//import mk.finki.ukim.mk.lab.service.LocationService;
//import org.springframework.stereotype.Repository;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Objects;
//
//@Repository
//public class EventRepository {
//
//    private final List<Event> events;
//
//    public EventRepository(LocationService locationService) {
//        events = new ArrayList<>();
////        List<Location> locations = locationService.findAll();
////
////        if(!locations.isEmpty()) {
////            events.add(new Event("Concert A", "Music Event", 4.5, locations.get(0)));
////            events.add(new Event("Festival B", "Cultural Event", 4.0, locations.get(1)));
////            events.add(new Event("Conference C", "Tech Event", 5.0, locations.get(2)));
////            events.add(new Event("Workshop D", "Educational Event", 4.8, locations.get(3)));
////            events.add(new Event("Webinar E", "Online Event", 3.9, locations.get(4)));
////
////            events.add(new Event("Meetup F", "Networking Event", 4.7, locations.get(0)));
////            events.add(new Event("Seminar G", "Business Event", 4.1, locations.get(1)));
////            events.add(new Event("Hackathon H", "Programming Event", 5.0, locations.get(2)));
////            events.add(new Event("Charity I", "Fundraising Event", 4.6, locations.get(3)));
////            events.add(new Event("Exhibition J", "Art Event", 4.3, locations.get(4)));
////        }
//    }
//
//    public List<Event> findAll() {
//        return events;
//    }
//
//    public List<Event> searchEvents(String text) {
//        String[] parts = text.split(",");
//
//        String searchText = parts[0].trim();
//        double minRating = parts.length > 1 ? Double.parseDouble(parts[1].trim()) : 0;
//
//        return events.stream()
//                .filter(event -> (event.getName().toLowerCase().contains(searchText.toLowerCase()) ||
//                        event.getDescription().toLowerCase().contains(searchText.toLowerCase())) &&
//                        event.getPopularityScore() >= minRating)
//                .toList();
//    }
//
//    public Event saveEvent(Event event) {
//        events.add(new Event(event.getName(), event.getDescription(), event.getPopularityScore(), event.getLocation()));
//        return event;
//    }
//
//    public Event findById(Long id) {
//        for (Event event : events) {
//            if (Objects.equals(event.getId(), id)) {
//                return event;
//            }
//        }
//        return null;
//    }
//
//    public void deleteEvent(Event event) {
//        events.remove(event);
//    }
//
//}
