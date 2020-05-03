package pearls.com.infrastructure.jpa.masters.city;

import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;
import pearls.com.domain.model.master.City;
import pearls.com.domain.usecase.master.port.CityRepository;
import pearls.com.infrastructure.jpa.common.AdapterOperations;
import pearls.com.infrastructure.jpa.common.MapperUtil;
import pearls.com.infrastructure.jpa.masters.state.StateData;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CityDataRepositoryAdapter extends AdapterOperations<CityData, Long, CityDataRepository> implements CityRepository {

    public CityDataRepositoryAdapter(CityDataRepository repository, ObjectMapper mapper) {
        super(repository);
    }

    @Override
    public List<City> getCitiesByState(Long state) {
        StateData stateData = new StateData();
        stateData.setCode(state);
        return this.repository.findByState(stateData).stream().map(cityData -> MapperUtil.mapCity(cityData)).collect(Collectors.toList());
    }

    @Override
    public City getCityById(Long code) {
        CityData cityData = this.getById(code);
        return MapperUtil.mapCity(cityData);
    }
}
