package mk.finki.ukim.mk.lab.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import java.util.List;


@Data
@Getter
@Setter
@Entity
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String address;
    private Integer capacity;


    @OneToMany(mappedBy = "location")
    private List<Event> event;

    public Location(String name, Integer capacity, String address, String description) {
        this.name = name;
        this.capacity = capacity;
        this.address = address;
        this.description = description;
    }

    public Location() {

    }
}
