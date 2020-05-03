package pearls.com.infrastructure.jpa.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pearls.com.domain.model.customer.Customer;
import pearls.com.domain.usecase.customer.port.CustomerRepository;
import pearls.com.domain.usecase.visit.port.VisitRepository;
import pearls.com.infrastructure.jpa.common.AdapterOperations;
import pearls.com.infrastructure.jpa.common.MapperUtil;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CustomerDataRepositoryAdapter extends AdapterOperations<CustomerData, String, CustomerDataRepository> implements CustomerRepository{

    private static final String USER_DELETED_SUCCESSFULLY = "User deleted succesfully";
    private static final String USER_CREATED_SUCCESSFULLY = "User created succesfully";
    private static final String USER_UPDATED_SUCCESSFULLY = "User updated succesfully";

    @Autowired
    VisitRepository visitRepository;

    public CustomerDataRepositoryAdapter(CustomerDataRepository repository) {
        super(repository);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return this.getAll().stream().map(customerData ->
            MapperUtil.mapCustomer(customerData)
        ).collect(Collectors.toList());
    }

    @Override
    public Customer getCustomerByCustomerId(String id) {
        CustomerData customerData = this.getById(id);
        return MapperUtil.mapCustomer(customerData);
    }

    @Override
    public String deleteCustomer(String id) {
        this.delete(id);
        return USER_DELETED_SUCCESSFULLY;
    }

    @Override
    public String updateCustomer(Customer customer) {
        this.save(MapperUtil.mapCustomerData(customer));
        return USER_UPDATED_SUCCESSFULLY;
    }

    @Override
    public String createCustomer(Customer customer) {
        this.save(MapperUtil.mapCustomerData(customer));
        return USER_CREATED_SUCCESSFULLY;
    }

    @Override
    public void updateAvailableCreditFromCustomer(String customer, double totalVisit) {
        CustomerData customerData = this.getById(customer);
        customerData.setAvailableCredit(customerData.getAvailableCredit() - totalVisit);
        this.save(customerData);
    }
}
