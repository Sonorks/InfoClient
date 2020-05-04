package pearls.com.infrastructure.entrypoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pearls.com.domain.model.customer.Customer;
import pearls.com.domain.model.customer.contract.InputCustomerData;
import pearls.com.domain.usecase.customer.CustomerUseCase;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value="/customer",produces = MediaType.APPLICATION_JSON_VALUE)
public class CustomerService {

    @Autowired
    private CustomerUseCase customerUseCase;


    @GetMapping
    public List<Customer> getAllCustomers(){
        return customerUseCase.getAllCustomers();
    }

    @GetMapping(value="/{nit}")
    public Customer getCustomerById(@PathVariable("nit") String nit){
        return customerUseCase.getCustomerById(nit);
    }

    @PostMapping
    public String createCustomer(@RequestBody InputCustomerData inputCustomerData){
        return customerUseCase.createCustomer(inputCustomerData);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PutMapping
    public String updateCustomer(@RequestBody InputCustomerData inputCustomerData){
        return customerUseCase.updateCustomer(inputCustomerData);
    }

    @DeleteMapping(value="/{nit}")
    public String deleteCustomer(@PathVariable("nit") String nit){
        return customerUseCase.deleteCustomer(nit);
    }


}
