package mk.finki.ukim.mk.lab.model;


import lombok.Getter;

public class EventBooking {

    @Getter
    private  String eventName;
    @Getter
    private  String attendeeName;
    @Getter
    private  String attendeeAddress;
    @Getter
    private  Long numberOfTickets;

    public EventBooking(String eventName, String attendeeName, String attendeeAddress, Long numberOfTickets) {
        this.eventName = eventName;
        this.attendeeName = attendeeName;
        this.attendeeAddress = attendeeAddress;
        this.numberOfTickets = numberOfTickets;
    }

    @Override
    public String toString() {
        return "EventBooking{" +
                "eventName='" + eventName + '\'' +
                ", attendeeName='" + attendeeName + '\'' +
                ", attendeeAddress='" + attendeeAddress + '\'' +
                ", numberOfTickets=" + numberOfTickets +
                '}';
    }
}