package mk.ukim.finki.emt_lab.web;

import mk.ukim.finki.emt_lab.model.Country;
import mk.ukim.finki.emt_lab.model.dto.CountryDTO;
import mk.ukim.finki.emt_lab.service.CountryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/countries")
public class CountryController {
    private final CountryService service;

    public CountryController(CountryService service) {
        this.service = service;
    }

    @PostMapping("/add-country")
    public ResponseEntity<Void> addCountry(@RequestBody CountryDTO countryDTO){
        if(countryDTO == null){
            return ResponseEntity.notFound().build();
        }

        this.service.create(countryDTO.getName(),countryDTO.getContinent());
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete-country/{id}")
    public ResponseEntity<Void> deleteCountry(@PathVariable Long id) {
        if (id == null) {
            return ResponseEntity.notFound().build();
        }

        this.service.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public List<Country> getCountries(){
        return this.service.listAll();
    }


}
