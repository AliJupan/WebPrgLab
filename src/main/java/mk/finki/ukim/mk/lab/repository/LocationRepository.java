//package mk.finki.ukim.mk.lab.repository;
//
//import mk.finki.ukim.mk.lab.model.Location;
//import org.springframework.stereotype.Repository;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Objects;
//
//@Repository
//public class LocationRepository {
//    private final List<Location> locations;
//
//    public LocationRepository() {
//
//          locations = new ArrayList<>();
////        locations.add(new Location("Central Park", 500, "123 Main St", "Open-air event space in the city center"));
////        locations.add(new Location("Art Gallery", 150, "456 Elm St", "Indoor gallery for art exhibitions"));
////        locations.add(new Location("The Grand Theater", 300, "789 Oak St", "Classic theater for live performances"));
////        locations.add(new Location("Gourmet Plaza", 250, "101 Maple Ave", "Outdoor space for food and cultural events"));
////        locations.add(new Location("Tech Arena", 1000, "202 Pine Ave", "Large venue for tech conferences and expos"));
//    }
//
//    public List<Location> findAll() {
//        return locations;
//    }
//
//    public Location findById(Long id) {
//        for (Location location : locations) {
//            if (Objects.equals(location.getId(), id)) {
//                return location;
//            }
//        }
//        return null;
//    }
//}
