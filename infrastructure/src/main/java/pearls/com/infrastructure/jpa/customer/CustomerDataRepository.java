package pearls.com.infrastructure.jpa.customer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDataRepository extends JpaRepository<CustomerData, String> {
}
