package mk.ukim.finki.emt_lab.service.impl;


import mk.ukim.finki.emt_lab.events.AccomodationCreatedEvent;
import mk.ukim.finki.emt_lab.events.AccomodationDeletedEvent;
import mk.ukim.finki.emt_lab.events.AccomodationEditedEvent;
import mk.ukim.finki.emt_lab.model.Accomodation;
import mk.ukim.finki.emt_lab.model.Category;
import mk.ukim.finki.emt_lab.model.Host;
import mk.ukim.finki.emt_lab.model.exceptions.AccomodationNotFoundException;
import mk.ukim.finki.emt_lab.repository.AccomodationRepository;
import mk.ukim.finki.emt_lab.repository.HostRepository;
import mk.ukim.finki.emt_lab.service.AccomodationService;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccomodationServiceImpl implements AccomodationService {

    private final AccomodationRepository accomodationRepository;
    private final HostRepository hostRepository;
    private final ApplicationEventPublisher applicationEventPublisher;

    public AccomodationServiceImpl(AccomodationRepository accomodationRepository, HostRepository hostRepository, ApplicationEventPublisher applicationEventPublisher) {
        this.accomodationRepository = accomodationRepository;
        this.hostRepository = hostRepository;
        this.applicationEventPublisher = applicationEventPublisher;
    }

    @Override
    public List<Accomodation> listAll() {
        return this.accomodationRepository.findAll();
    }

    @Override
    public Accomodation findById(Long id) {
        return this.accomodationRepository.findById(id).orElseThrow(AccomodationNotFoundException::new);
    }

    @Override
    public void deleteById(Long id) {
        var accomodation = this.findById(id);
        this.applicationEventPublisher.publishEvent(new AccomodationDeletedEvent(accomodation));
        this.accomodationRepository.delete(accomodation);

    }

    @Override
    public Accomodation create(String name, Category category, Long hostId, Integer numRooms) {
        Host host = hostRepository.findById(hostId).get();
        Accomodation accomodation = new Accomodation(name, category, host, numRooms);
        this.applicationEventPublisher.publishEvent(new AccomodationCreatedEvent(accomodation));
        return accomodationRepository.save(accomodation);
    }

    @Override
    public Accomodation update(Long id, String name, Category category, Long hostId, Integer numRooms) {
        Accomodation accomodation = this.findById(id);
        Host host = hostRepository.findById(hostId).get();

        accomodation.setName(name);
        accomodation.setCategory(category);
        accomodation.setHost(host);
        accomodation.setNumRooms(numRooms);

        this.applicationEventPublisher.publishEvent(new AccomodationEditedEvent(accomodation));
        return accomodationRepository.save(accomodation);

    }


    @Override
    public void mark(Long id) {
    Accomodation accomodation = this.findById(id);
    accomodation.setNumRooms(accomodation.getNumRooms() - 1);
    accomodationRepository.save(accomodation);
    }

    @Override
    public void onAccomodationCreated() {
        System.out.println("[CREATE]: Accomodation created successfully");
    }

    @Override
    public void onAccomodationEdited() {
        System.out.println("[EDIT]: Accomodation edited successfully");
    }

    @Override
    public void onAccomodationDeleted() {
        System.out.println("[DELETE]: Accomodation deleted successfully");
    }
}
