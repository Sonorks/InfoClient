package pearls.com.infoclient;

import org.reactivecommons.utils.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pearls.com.domain.usecase.customer.CustomerUseCase;
import pearls.com.domain.usecase.customer.port.CustomerRepository;
import pearls.com.domain.usecase.master.MasterUseCase;
import pearls.com.domain.usecase.master.port.CityRepository;
import pearls.com.domain.usecase.master.port.CountryRepository;
import pearls.com.domain.usecase.master.port.SalesRepresentativeRepository;
import pearls.com.domain.usecase.master.port.StateRepository;
import pearls.com.domain.usecase.visit.VisitUseCase;
import pearls.com.domain.usecase.visit.port.VisitRepository;

@Configuration
public class UseCaseConfiguration {

    @Bean
    public VisitUseCase visitUseCase(VisitRepository visitRepository, CustomerRepository customerRepository, CityRepository cityRepository){
        return new VisitUseCase(visitRepository, customerRepository, cityRepository);
    }

    @Bean
    public CustomerUseCase customerUseCase(CustomerRepository customerRepository, CityRepository cityRepository,
                                           StateRepository stateRepository, CountryRepository countryRepository){
        return new CustomerUseCase(customerRepository, cityRepository, stateRepository, countryRepository);
    }

    @Bean
    public MasterUseCase masterUseCase(CityRepository cityRepository,
            CountryRepository countryRepository,
            SalesRepresentativeRepository salesRepresentativeRepository,
            StateRepository stateRepository){
        return new MasterUseCase(cityRepository,countryRepository,salesRepresentativeRepository,stateRepository);
    }

    @Bean
    public ObjectMapper objectMapper(){
        return new org.reactivecommons.utils.ObjectMapperImp();
    }


}
