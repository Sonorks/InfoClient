package pearls.com.domain.usecase.master.port;

import pearls.com.domain.model.master.State;

import java.util.List;

public interface StateRepository {
    List<State> getStatesByCountry(Long country);

    State getStateById(Long code);
}
