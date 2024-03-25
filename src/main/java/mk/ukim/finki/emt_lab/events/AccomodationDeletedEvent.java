package mk.ukim.finki.emt_lab.events;

import mk.ukim.finki.emt_lab.model.Accomodation;
import org.springframework.context.ApplicationEvent;

public class AccomodationDeletedEvent extends ApplicationEvent {
    public AccomodationDeletedEvent(Accomodation accomodation) {
        super(accomodation);
    }
}
