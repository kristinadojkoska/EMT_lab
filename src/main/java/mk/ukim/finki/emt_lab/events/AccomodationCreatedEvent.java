package mk.ukim.finki.emt_lab.events;

import mk.ukim.finki.emt_lab.model.Accomodation;
import org.springframework.context.ApplicationEvent;

public class AccomodationCreatedEvent extends ApplicationEvent {
public AccomodationCreatedEvent(Accomodation accomodation){

    super(accomodation);
}
}
