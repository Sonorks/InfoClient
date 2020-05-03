package pearls.com.domain.usecase.master.port;

import pearls.com.domain.model.master.City;

import java.util.List;

public interface CityRepository {
    List<City> getCitiesByState(Long state);
    City getCityById(Long code);
}
