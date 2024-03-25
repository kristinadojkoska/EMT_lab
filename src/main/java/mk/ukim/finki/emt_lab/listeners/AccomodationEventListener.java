package mk.ukim.finki.emt_lab.listeners;

import mk.ukim.finki.emt_lab.events.AccomodationCreatedEvent;
import mk.ukim.finki.emt_lab.events.AccomodationDeletedEvent;
import mk.ukim.finki.emt_lab.events.AccomodationEditedEvent;
import mk.ukim.finki.emt_lab.service.AccomodationService;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class AccomodationEventListener {
    private final AccomodationService accomodationService;

    public AccomodationEventListener(AccomodationService accomodationService) {
        this.accomodationService = accomodationService;
    }

    @EventListener
    public void onAccomodationCreated(AccomodationCreatedEvent event){
        this.accomodationService.onAccomodationCreated();
    }

    @EventListener
    public void onAccomodationDeleted(AccomodationDeletedEvent event){
        this.accomodationService.onAccomodationDeleted();
    }

    @EventListener
    public void onAccomodationEdited(AccomodationEditedEvent event){
        this.accomodationService.onAccomodationEdited();
    }
}
