package mk.ukim.finki.emt_lab.model;

import jakarta.persistence.*;
import lombok.Data;
import mk.ukim.finki.emt_lab.model.Country;
@Data
@Entity
public class Host {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   Long id;
   String name;
   String surname;
  @ManyToOne
   Country country;

  public Host(){}
   public Host(String name, String surname, Country country) {
      this.name = name;
      this.surname = surname;
      this.country = country;
   }
}
