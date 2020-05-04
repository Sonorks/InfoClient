package pearls.com.infrastructure.jpa.common;

import pearls.com.domain.model.customer.Customer;
import pearls.com.domain.model.master.City;
import pearls.com.domain.model.master.Country;
import pearls.com.domain.model.master.SalesRepresentative;
import pearls.com.domain.model.master.State;
import pearls.com.domain.model.visit.Visit;
import pearls.com.infrastructure.jpa.customer.CustomerData;
import pearls.com.infrastructure.jpa.masters.city.CityData;
import pearls.com.infrastructure.jpa.masters.country.CountryData;
import pearls.com.infrastructure.jpa.masters.salesrepresentative.SalesRepData;
import pearls.com.infrastructure.jpa.masters.state.StateData;
import pearls.com.infrastructure.jpa.visit.VisitData;


public class MapperUtil {

    public static Customer mapCustomer(CustomerData customerData){
        return Customer.builder()
                .address(customerData.getAddress())
                .availableCredit(customerData.getAvailableCredit())
                .city(customerData.getCity().getDescription())
                .country(customerData.getCountry().getDescription())
                .creditLimit(customerData.getCreditLimit())
                .fullname(customerData.getFullname())
                .nit(customerData.getNit())
                .phone(customerData.getPhone())
                .state(customerData.getState().getDescription())
                .visitsPercentage(customerData.getVisits_percentage())
                .build();
    }

    public static City mapCity(CityData cityData){
        return City.builder()
                .description(cityData.getDescription())
                .code(cityData.getCode())
                .state(cityData.getState().getCode())
                .build();
    }

    public static Country mapCountry(CountryData countryData) {
        return Country.builder()
                .description(countryData.getDescription())
                .code(countryData.getCode())
                .build();
    }

    public static State mapState(StateData stateData){
        return State.builder()
                .description(stateData.getDescription())
                .country(stateData.getCountry().getCode())
                .code(stateData.getCode())
                .build();
    }

    public static SalesRepresentative mapSalesRep(SalesRepData salesRepData) {
        return SalesRepresentative.builder()
                .code(salesRepData.getCode())
                .name(salesRepData.getName())
                .build();
    }

    public static CustomerData mapCustomerData(Customer customer) {
        CityData city = new CityData();
        city.setCode(Long.parseLong(customer.getCity()));
        CountryData country = new CountryData();
        country.setCode(Long.parseLong(customer.getCountry()));
        StateData state = new StateData();
        state.setCode(Long.parseLong(customer.getState()));
        CustomerData customerData = new CustomerData();
        customerData.setAddress(customer.getAddress());
        customerData.setAvailableCredit(customer.getAvailableCredit());
        customerData.setCity(city);
        customerData.setCountry(country);
        customerData.setCreditLimit(customer.getCreditLimit());
        customerData.setFullname(customer.getFullname());
        customerData.setNit(customer.getNit());
        customerData.setPhone(customer.getPhone());
        customerData.setState(state);
        customerData.setVisits_percentage(customer.getVisitsPercentage());
        return customerData;
    }

    public static Visit mapVisit(VisitData visitData) {
        return Visit.builder()
                .customer(visitData.getIdcustomer().getNit())
                .date(visitData.getDate())
                .description(visitData.getDescription())
                .net(visitData.getNet())
                .salesRepresentative(visitData.getSalesRepresentative().getCode())
                .visitTotal(visitData.getVisit_total())
                .city(visitData.getCity())
                .build();
    }

    public static VisitData mapVisitData(Visit visit) {
        CustomerData customerData = new CustomerData();
        customerData.setNit(visit.getCustomer());
        SalesRepData salesRepData = new SalesRepData();
        salesRepData.setCode(visit.getSalesRepresentative());
        VisitData visitData = new VisitData();
        visitData.setIdcustomer(customerData);
        visitData.setDate(visit.getDate());
        visitData.setDescription(visit.getDescription());
        visitData.setNet(visit.getNet());
        visitData.setVisit_total(visit.getVisitTotal());
        visitData.setSalesRepresentative(salesRepData);
        visitData.setCity(visit.getCity());
        return visitData;
    }
}
