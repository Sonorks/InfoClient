package pearls.com.infrastructure.jpa.customer;

import lombok.Data;
import lombok.NoArgsConstructor;
import pearls.com.infrastructure.jpa.masters.city.CityData;
import pearls.com.infrastructure.jpa.masters.country.CountryData;
import pearls.com.infrastructure.jpa.masters.state.StateData;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@Table(name="customer")
public class CustomerData {
    @Id
    private String nit;
    private String fullname;
    private String address;
    private String phone;
    @ManyToOne
    @JoinColumn(name="city", referencedColumnName = "code")
    private CityData city;
    @ManyToOne
    @JoinColumn(name="state", referencedColumnName = "code")
    private StateData state;
    @ManyToOne
    @JoinColumn(name="country", referencedColumnName = "code")
    private CountryData country;
    private double creditLimit;
    private double availableCredit;
    private double visits_percentage;
}
