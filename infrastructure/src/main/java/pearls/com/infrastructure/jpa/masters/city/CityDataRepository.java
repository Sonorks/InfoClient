package pearls.com.infrastructure.jpa.masters.city;

import org.springframework.data.jpa.repository.JpaRepository;
import pearls.com.infrastructure.jpa.masters.state.StateData;

import java.util.List;

public interface CityDataRepository extends JpaRepository<CityData, Long> {
    List<CityData> findByState(StateData state);
}
