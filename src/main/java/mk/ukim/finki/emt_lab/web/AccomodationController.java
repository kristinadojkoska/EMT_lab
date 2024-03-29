package mk.ukim.finki.emt_lab.web;

import mk.ukim.finki.emt_lab.model.Accomodation;
import mk.ukim.finki.emt_lab.model.Host;
import mk.ukim.finki.emt_lab.model.dto.AccomodationDTO;
import mk.ukim.finki.emt_lab.service.AccomodationService;
import mk.ukim.finki.emt_lab.service.HostService;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accomodations")
public class AccomodationController {
    private final AccomodationService service;
    private final HostService hostService;

    public AccomodationController(AccomodationService service, HostService hostService) {
        this.service = service;
        this.hostService = hostService;
    }

    @GetMapping
    public List<Accomodation> getAccomodations(){
        return this.service.listAll();
    }

    @PostMapping("/add-accomodation")
    public ResponseEntity<Void> addAccomodation(@RequestBody AccomodationDTO accomodationDTO){
        if(accomodationDTO == null){
            return ResponseEntity.notFound().build();
        }

        if(hostService.findById(accomodationDTO.getHostId()) == null){
            return ResponseEntity.notFound().build();
        }

        this.service.create(accomodationDTO.getName(), accomodationDTO.getCategory(), accomodationDTO.getHostId(), accomodationDTO.getNumRooms());
        return ResponseEntity.ok().build();

    }


    @DeleteMapping("/delete-accomodation/{id}")
    public ResponseEntity<Void> deleteAccomodation(@PathVariable Long id){
        if(id == null){
            return ResponseEntity.notFound().build();
        }

        if(service.findById(id) == null){
            return ResponseEntity.notFound().build();
        }

        this.service.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/edit-accomodation/{id}")
    public ResponseEntity<Void> editAccomodation(@PathVariable Long id, @RequestBody AccomodationDTO accomodationDTO){
        if(accomodationDTO == null){
            return ResponseEntity.notFound().build();
        }

        if(hostService.findById(accomodationDTO.getHostId()) == null || service.findById(id) == null){
            return ResponseEntity.notFound().build();
        }
        this.service.update(id, accomodationDTO.getName(), accomodationDTO.getCategory(), accomodationDTO.getHostId(), accomodationDTO.getNumRooms());
        return ResponseEntity.ok().build();
    }

    @PostMapping("/mark-accomodation/{id}")
    public ResponseEntity<Void> markAccomodation(@PathVariable Long id){
        if(id == null){
            return ResponseEntity.notFound().build();
        }

        if(service.findById(id) == null){
            return ResponseEntity.notFound().build();
        }

        this.service.mark(id);
        return ResponseEntity.ok().build();
    }

}
