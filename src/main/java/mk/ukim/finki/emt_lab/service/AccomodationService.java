package mk.ukim.finki.emt_lab.service;

import mk.ukim.finki.emt_lab.model.Accomodation;
import mk.ukim.finki.emt_lab.model.Category;
import mk.ukim.finki.emt_lab.model.Host;
import org.springframework.stereotype.Service;

import java.util.List;


public interface AccomodationService {
    List<Accomodation> listAll();
    Accomodation findById(Long id);
    void deleteById(Long id);
    Accomodation create(String name, Category category, Long hostId, Integer numRooms);
    Accomodation update(Long id, String name, Category category, Long hostId, Integer numRooms);
    void mark(Long id);
    void onAccomodationCreated();
    void onAccomodationEdited();
    void onAccomodationDeleted();


}
