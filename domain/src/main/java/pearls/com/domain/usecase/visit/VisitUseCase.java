package pearls.com.domain.usecase.visit;

import lombok.RequiredArgsConstructor;
import pearls.com.domain.model.master.City;
import pearls.com.domain.model.visit.Visit;
import pearls.com.domain.model.visit.VisitPerCity;
import pearls.com.domain.usecase.customer.port.CustomerRepository;
import pearls.com.domain.usecase.master.port.CityRepository;
import pearls.com.domain.usecase.visit.port.VisitRepository;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class VisitUseCase {

    private final VisitRepository visitRepository;
    private final CustomerRepository customerRepository;
    private final CityRepository cityRepository;

    public List<Visit> getVisitsByCustomerId(String nit) {
        return visitRepository.getVisitByCustomerId(nit);
    }

    public String saveVisit(Visit visit) {
        customerRepository.updateAvailableCreditFromCustomer(visit.getCustomer(), visit.getVisitTotal());
        return visitRepository.saveVisit(visit);
    }

    public List<VisitPerCity> getVisitsByCity() {
        List<Visit> visits = visitRepository.getAllVisits();
        List<VisitPerCity> visitsPerCity = new ArrayList();
        List<City> allCities = cityRepository.getAllCities();
        allCities.forEach(city ->{
            long visitPerCity = visits.stream().filter(visit -> city.getDescription().equals(visit.getCity())).count();
            visitsPerCity.add(VisitPerCity.builder().city(city.getDescription()).number(visitPerCity).build());
        });
        return visitsPerCity;
    }
}
