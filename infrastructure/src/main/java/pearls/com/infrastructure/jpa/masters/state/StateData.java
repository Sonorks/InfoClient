package pearls.com.infrastructure.jpa.masters.state;


import lombok.Data;
import lombok.NoArgsConstructor;
import pearls.com.infrastructure.jpa.masters.country.CountryData;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name="state")
public class StateData {
    @Id
    private Long code;
    private String description;
    @ManyToOne
    @JoinColumn(name="country")
    private CountryData country;
}
