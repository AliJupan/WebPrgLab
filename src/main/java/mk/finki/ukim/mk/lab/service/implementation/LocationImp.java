package mk.finki.ukim.mk.lab.service.implementation;

import mk.finki.ukim.mk.lab.model.Location;
import mk.finki.ukim.mk.lab.repository.JPA.LocationRepository;
import mk.finki.ukim.mk.lab.service.LocationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationImp implements LocationService {

    LocationRepository repository;

    public LocationImp(LocationRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Location> findAll() {
        return repository.findAll();
    }
}
