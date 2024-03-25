package mk.ukim.finki.emt_lab.events;

import mk.ukim.finki.emt_lab.model.Accomodation;
import org.springframework.context.ApplicationEvent;

public class AccomodationEditedEvent extends ApplicationEvent {
    public AccomodationEditedEvent(Accomodation accomodation) {
        super(accomodation);
    }
}
