package pearls.com.infrastructure.jpa.masters.state;

import org.springframework.stereotype.Repository;
import pearls.com.domain.model.master.State;
import pearls.com.domain.usecase.master.port.StateRepository;
import pearls.com.infrastructure.jpa.common.AdapterOperations;
import pearls.com.infrastructure.jpa.common.MapperUtil;
import pearls.com.infrastructure.jpa.masters.country.CountryData;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class StateDataRepositoryAdapter extends AdapterOperations<StateData, Long, StateDataRepository> implements StateRepository {

    public StateDataRepositoryAdapter(StateDataRepository repository) {
        super(repository);
    }

    @Override
    public List<State> getStatesByCountry(Long country) {
        CountryData countryData = new CountryData();
        countryData.setCode(country);
        return this.repository.findByCountry(countryData).stream().map(MapperUtil::mapState).collect(Collectors.toList());
    }

    @Override
    public State getStateById(Long code) {
        StateData stateData = this.getById(code);
        return MapperUtil.mapState(stateData);
    }
}
