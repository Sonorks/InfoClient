package pearls.com.infrastructure.jpa.masters.salesrepresentative;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@NoArgsConstructor
@Table(name = "sales_representative")
public class SalesRepData {
    @Id
    private Long code;
    private String name;
}
