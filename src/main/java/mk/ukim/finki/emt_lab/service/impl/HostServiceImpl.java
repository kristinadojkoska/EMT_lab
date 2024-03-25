package mk.ukim.finki.emt_lab.service.impl;

import mk.ukim.finki.emt_lab.model.Host;
import mk.ukim.finki.emt_lab.model.exceptions.HostNotFoundException;
import mk.ukim.finki.emt_lab.repository.CountryRepository;
import mk.ukim.finki.emt_lab.repository.HostRepository;
import mk.ukim.finki.emt_lab.service.HostService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HostServiceImpl implements HostService {

    private final HostRepository hostRepository;
    private final CountryRepository countryRepository;

    public HostServiceImpl(HostRepository hostRepository, CountryRepository countryRepository) {
        this.hostRepository = hostRepository;
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Host> listAll() {
    return this.hostRepository.findAll();
    }

    @Override
    public Host findById(Long id) {
        return this.hostRepository.findById(id).orElseThrow(HostNotFoundException::new);
    }

    @Override
    public void deleteById(Long id) {
        var host = this.findById(id);
        this.hostRepository.delete(host);
    }

    @Override
    public Host create(String name, String surname, Long countryId) {
        var country = this.countryRepository.findById(countryId).get();
       return this.hostRepository.save(new Host(name, surname, country));
    }

    @Override
    public Host update(Long id, String name, String surname, Long countryId) {
        var host = this.findById(id);
        var country = this.countryRepository.findById(countryId).get();
        host.setName(name);
        host.setSurname(surname);
        host.setCountry(country);
        return this.hostRepository.save(host);
    }
}
