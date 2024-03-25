package mk.ukim.finki.emt_lab.model;

import jakarta.persistence.*;
import jakarta.servlet.http.PushBuilder;
import lombok.Data;
import org.hibernate.annotations.OnDelete;

@Data
@Entity
public class Accomodation {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    @Enumerated(EnumType.STRING)
    Category category;
    @ManyToOne
    //@OnDelete(action = onDeleteAction.CASCADE)
    Host host;
    Integer numRooms;

    public Accomodation(){}

    public Accomodation(String name, Category category, Host host, Integer numRooms) {
        this.name = name;
        this.category = category;
        this.host = host;
        this.numRooms = numRooms;
    }
}
