package mk.ukim.finki.emt_lab.service;

import mk.ukim.finki.emt_lab.model.Host;
import org.springframework.stereotype.Service;

import java.util.List;


public interface HostService {
List<Host> listAll();
Host findById(Long id);
void deleteById(Long id);
Host create(String name, String surname, Long countryId);
Host update(Long id, String name, String surname, Long countryId);


}
