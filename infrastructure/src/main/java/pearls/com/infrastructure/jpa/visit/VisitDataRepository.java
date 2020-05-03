package pearls.com.infrastructure.jpa.visit;

import org.springframework.data.jpa.repository.JpaRepository;
import pearls.com.infrastructure.jpa.customer.CustomerData;

import java.util.Arrays;
import java.util.List;

public interface VisitDataRepository extends JpaRepository<VisitData, Long> {
    List<VisitData> findByIdcustomer(CustomerData customerData);
}
