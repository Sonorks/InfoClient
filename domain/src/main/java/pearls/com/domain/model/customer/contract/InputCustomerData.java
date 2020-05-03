package pearls.com.domain.model.customer.contract;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@AllArgsConstructor
public class InputCustomerData {
    private String nit;
    private String fullname;
    private String address;
    private String phone;
    private Long city;
    private Long state;
    private Long country;
    private double creditLimit;
    private double availableCredit;
    private double visitPercentage;
}
