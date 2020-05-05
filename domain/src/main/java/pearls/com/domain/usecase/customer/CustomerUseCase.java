package pearls.com.domain.usecase.customer;

import lombok.RequiredArgsConstructor;
import pearls.com.domain.model.customer.Customer;
import pearls.com.domain.model.customer.contract.InputCustomerData;
import pearls.com.domain.usecase.customer.port.CustomerRepository;
import pearls.com.domain.usecase.master.port.CityRepository;
import pearls.com.domain.usecase.master.port.CountryRepository;
import pearls.com.domain.usecase.master.port.StateRepository;

import java.util.List;

import static pearls.com.domain.model.common.PhoneUtils.validateCellPhoneNumber;
import static pearls.com.domain.model.common.StringUtils.validateStringUsingRegexp;

@RequiredArgsConstructor
public class CustomerUseCase {

    private static final String INPUT_DATA_INVALID= "INPUT DATA INVALID, PLEASE CHECK THE INFORMATION.";
    private final CustomerRepository customerRepository;
    private final CityRepository cityRepository;
    private final StateRepository stateRepository;
    private final CountryRepository countryRepository;

    public Customer getCustomerById(String nit) {
        return customerRepository.getCustomerByCustomerId(nit);
    }

    public String createCustomer(InputCustomerData customerInput) {
        if(validateCustomerInput(customerInput)) {
            Customer customer = mapInputData(customerInput);
            return customerRepository.createCustomer(customer);
        } else {
            return INPUT_DATA_INVALID;
        }
    }

    private boolean validateCustomerInput(InputCustomerData customerInput) {
        return validateStringUsingRegexp(customerInput.getNit(), "^[A-Za-z0-9_]{1,20}$")
                && validateCellPhoneNumber(customerInput.getPhone())
                && validateStringUsingRegexp(customerInput.getFullname(), "^[A-Za-zÀ-ÿ\u00f1\u00d10-9_ -]{1,50}$");
    }

    public String updateCustomer(InputCustomerData customerInput) {
        Customer customer = mapInputData(customerInput);
        return customerRepository.updateCustomer(customer);
    }

    public String deleteCustomer(String nit) {
        return customerRepository.deleteCustomer(nit);
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.getAllCustomers();
    }

    private Customer mapInputData(InputCustomerData customerInput) {
        Long city = cityRepository.getCityById(customerInput.getCity()).getCode();
        Long state = stateRepository.getStateById(customerInput.getState()).getCode();
        Long country = countryRepository.getCountryById(customerInput.getCountry()).getCode();
        return Customer.builder()
                .address(customerInput.getAddress())
                .availableCredit(customerInput.getAvailableCredit())
                .city(city.toString())
                .country(country.toString())
                .creditLimit(customerInput.getCreditLimit())
                .fullname(customerInput.getFullname())
                .nit(customerInput.getNit())
                .phone(customerInput.getPhone())
                .state(state.toString())
                .visitsPercentage(customerInput.getVisitsPercentage())
                .build();
    }


}
