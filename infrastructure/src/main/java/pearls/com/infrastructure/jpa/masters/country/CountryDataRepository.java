package pearls.com.infrastructure.jpa.masters.country;

import org.springframework.data.jpa.repository.JpaRepository;


public interface CountryDataRepository extends JpaRepository<CountryData, Long> {

}
