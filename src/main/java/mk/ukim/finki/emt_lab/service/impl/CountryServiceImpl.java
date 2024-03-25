package mk.ukim.finki.emt_lab.service.impl;

import mk.ukim.finki.emt_lab.model.Country;
import mk.ukim.finki.emt_lab.model.exceptions.CountryNotFoundException;
import mk.ukim.finki.emt_lab.repository.CountryRepository;
import mk.ukim.finki.emt_lab.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Country> listAll() {
        return this.countryRepository.findAll();
    }

    @Override
    public Country findById(Long id) {
        return this.countryRepository.findById(id).orElseThrow(CountryNotFoundException::new);
    }

    @Override
    public void deleteById(Long Id) {
        var country = this.findById(Id);
        this.countryRepository.delete(country);
    }

    @Override
    public Country create(String name, String continent) {
        return this.countryRepository.save(new Country(name, continent));
    }

    @Override
    public Country update(Long id, String name, String continent) {
        var country = this.findById(id);
        country.setName(name);
        country.setContinent(continent);
        return this.countryRepository.save(country);
    }

}
