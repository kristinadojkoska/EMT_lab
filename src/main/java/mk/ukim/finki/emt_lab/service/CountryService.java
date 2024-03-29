package mk.ukim.finki.emt_lab.service;

import mk.ukim.finki.emt_lab.model.Country;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CountryService {
    List<Country> listAll();
    Country findById(Long id);
    void deleteById(Long Id);
    Country create(String name, String continent);
    Country update(Long id, String name, String continent);

}
