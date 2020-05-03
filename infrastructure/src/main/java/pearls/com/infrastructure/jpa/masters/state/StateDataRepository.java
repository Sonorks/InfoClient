package pearls.com.infrastructure.jpa.masters.state;

import org.springframework.data.jpa.repository.JpaRepository;
import pearls.com.infrastructure.jpa.masters.country.CountryData;

import java.util.List;

public interface StateDataRepository extends JpaRepository<StateData, Long> {

    List<StateData> findByCountry(CountryData country);
}
