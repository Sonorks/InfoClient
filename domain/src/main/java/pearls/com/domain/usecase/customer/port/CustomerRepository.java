package pearls.com.domain.usecase.customer.port;

import pearls.com.domain.model.customer.Customer;

import java.util.List;

public interface CustomerRepository {

    List<Customer> getAllCustomers();
    Customer getCustomerByCustomerId(String id);
    String deleteCustomer(String id);
    String updateCustomer(Customer customer);
    String createCustomer(Customer customer);
    void updateAvailableCreditFromCustomer(String customer, double totalVisit);
}
