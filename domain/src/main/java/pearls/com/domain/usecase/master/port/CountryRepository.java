package pearls.com.domain.usecase.master.port;

import pearls.com.domain.model.master.Country;

import java.util.List;

public interface CountryRepository {

    List<Country> getMasterCountry();

    Country getCountryById(Long code);
}
