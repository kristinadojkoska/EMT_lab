package mk.ukim.finki.emt_lab.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.random.RandomGenerator;
@Data
@Entity
public class Country{
    public Country(){}
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String continent;

    public Country( String name, String continent) {
        this.name = name;
        this.continent = continent;
    }

}
