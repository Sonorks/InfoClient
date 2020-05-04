package pearls.com.domain.model.customer;

import lombok.Builder;
import lombok.Getter;


@Builder
@Getter
public class Customer {
    private String nit;
    private String fullname;
    private String address;
    private String phone;
    private String city;
    private String state;
    private String country;
    private double creditLimit;
    private double availableCredit;
    private double visitsPercentage;
}
