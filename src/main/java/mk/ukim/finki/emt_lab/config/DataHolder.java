package mk.ukim.finki.emt_lab.config;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.emt_lab.model.Category;
import mk.ukim.finki.emt_lab.model.Country;
import mk.ukim.finki.emt_lab.model.Host;
import mk.ukim.finki.emt_lab.service.AccomodationService;
import mk.ukim.finki.emt_lab.service.CountryService;
import mk.ukim.finki.emt_lab.service.HostService;
import org.springframework.stereotype.Component;

@Component
public class DataHolder {
    private final AccomodationService accomodationService;
    private final CountryService countryService;
    private final HostService hostService;

    public DataHolder(AccomodationService accomodationService, CountryService countryService, HostService hostService) {
        this.accomodationService = accomodationService;
        this.countryService = countryService;
        this.hostService = hostService;
    }

    @PostConstruct
    public void init(){
        Country country1=this.countryService.create("Germany", "Europe");
        Country country2=this.countryService.create("Canada", "America");
        Country country3=this.countryService.create("China", "Asia");

        Host host1=this.hostService.create("Kristina","Dojkoska", country1.getId());
        Host host2=this.hostService.create("Joe","Overboe", country2.getId());
        Host host3=this.hostService.create("Emily","Jackson", country3.getId());


        this.accomodationService.create(String.valueOf(country1),Category.APARTMENT, host1.getId(), 2);
        this.accomodationService.create(String.valueOf(country2),Category.APARTMENT, host2.getId(), 5);
        this.accomodationService.create(String.valueOf(country3),Category.APARTMENT, host3.getId(), 10);

    }
}
