package mk.ukim.finki.emt_lab.web;

import mk.ukim.finki.emt_lab.model.Host;
import mk.ukim.finki.emt_lab.model.dto.HostDTO;
import mk.ukim.finki.emt_lab.service.CountryService;
import mk.ukim.finki.emt_lab.service.HostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hosts")
public class HostController {

    private final HostService service;
    private final CountryService countryService;

    public HostController(HostService service, CountryService countryService) {
        this.service = service;
        this.countryService = countryService;
    }

    @GetMapping()
    public List<Host> getHosts() {
        return this.service.listAll();
    }

    @PostMapping("/add-host")
    public ResponseEntity<Host> addHost(@RequestBody HostDTO hostDTO){
        if(hostDTO == null){
            return  ResponseEntity.notFound().build();
        }

        if(countryService.findById(hostDTO.getCountryId()) == null){
            return ResponseEntity.ok().build();
        }

        this.service.create(hostDTO.getName(),hostDTO.getSurname(), hostDTO.getCountryId());
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete-host/{id}")
    public ResponseEntity<Void> getHosts(@PathVariable Long id){
        if(id == null){
            return ResponseEntity.notFound().build();
        }

        this.service.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
