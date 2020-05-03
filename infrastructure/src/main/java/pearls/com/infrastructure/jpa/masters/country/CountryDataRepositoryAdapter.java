package pearls.com.infrastructure.jpa.masters.country;

import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;
import pearls.com.domain.model.master.Country;
import pearls.com.domain.usecase.master.port.CountryRepository;
import pearls.com.infrastructure.jpa.common.AdapterOperations;
import pearls.com.infrastructure.jpa.common.MapperUtil;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CountryDataRepositoryAdapter extends AdapterOperations<CountryData, Long, CountryDataRepository> implements CountryRepository {
    public CountryDataRepositoryAdapter(CountryDataRepository repository, ObjectMapper mapper) {
        super(repository);
    }

    @Override
    public List<Country> getMasterCountry() {
        return this.getAll().stream().map(countryData -> MapperUtil.mapCountry(countryData)).collect(Collectors.toList());
    }

    @Override
    public Country getCountryById(Long code) {
        CountryData countryData = this.getById(code);
        return MapperUtil.mapCountry(countryData);
    }

    public CountryData getCountryDataById(Long code){
        return this.getById(code);
    }
}
