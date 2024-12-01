package mk.finki.ukim.mk.lab.service.implementation;

import mk.finki.ukim.mk.lab.model.EventBooking;
import mk.finki.ukim.mk.lab.repository.EventBookingRepository;
import mk.finki.ukim.mk.lab.service.EventBookingService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventBookingImp implements EventBookingService {

    EventBookingRepository eventBookingRepository;

    public EventBookingImp(EventBookingRepository eventBookingRepository) {
        this.eventBookingRepository = eventBookingRepository;
    }

    @Override
    public EventBooking placeBooking(String eventName, String attendeeName, String attendeeAddress, int numberOfTickets) {
        return eventBookingRepository.save(new EventBooking(eventName, attendeeName, attendeeAddress, (long)numberOfTickets));
    }

    @Override
    public List<EventBooking> listAll(){
        return eventBookingRepository.findAll();
    }

    @Override
    public List<EventBooking> searchEvents(String text){
        return eventBookingRepository.searchEvents(text);
    }

}
