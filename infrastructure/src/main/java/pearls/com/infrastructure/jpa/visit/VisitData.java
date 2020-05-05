package pearls.com.infrastructure.jpa.visit;

import lombok.Data;
import lombok.NoArgsConstructor;
import pearls.com.infrastructure.jpa.customer.CustomerData;
import pearls.com.infrastructure.jpa.masters.salesrepresentative.SalesRepData;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@Table(name="visit")
public class VisitData {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name="idcustomer")
    private CustomerData idcustomer;
    private Date date;
    @OneToOne
    @JoinColumn(name="sales_representative")
    private SalesRepData salesRepresentative;
    private double net;
    private double visit_total;
    private String description;
    private String city;
}
