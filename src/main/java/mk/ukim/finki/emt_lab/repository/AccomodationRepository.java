package mk.ukim.finki.emt_lab.repository;

import mk.ukim.finki.emt_lab.model.Accomodation;
import mk.ukim.finki.emt_lab.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccomodationRepository extends JpaRepository<Accomodation,Long> {
}
