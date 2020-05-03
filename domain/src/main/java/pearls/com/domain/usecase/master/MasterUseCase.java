package pearls.com.domain.usecase.master;

import lombok.RequiredArgsConstructor;
import pearls.com.domain.model.master.City;
import pearls.com.domain.model.master.Country;
import pearls.com.domain.model.master.SalesRepresentative;
import pearls.com.domain.model.master.State;
import pearls.com.domain.usecase.master.port.CityRepository;
import pearls.com.domain.usecase.master.port.CountryRepository;
import pearls.com.domain.usecase.master.port.SalesRepresentativeRepository;
import pearls.com.domain.usecase.master.port.StateRepository;

import java.util.List;

@RequiredArgsConstructor
public class MasterUseCase {

    private final CityRepository cityRepository;
    private final CountryRepository countryRepository;
    private final SalesRepresentativeRepository salesRepresentativeRepository;
    private final StateRepository stateRepository;


    public List<Country> getCountryMaster() {
        return countryRepository.getMasterCountry();
    }

    public List<State> getStateMasterByCountry(Long country) {
        return stateRepository.getStatesByCountry(country);
    }

    public List<City> getCityMasterByState(Long state) {
        return cityRepository.getCitiesByState(state);
    }

    public List<SalesRepresentative> getSalesRepresentativeMaster() {
        return salesRepresentativeRepository.getSalesRepresentativeMaster();
    }
}
