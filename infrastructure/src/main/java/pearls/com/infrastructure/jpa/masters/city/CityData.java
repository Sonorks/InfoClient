package pearls.com.infrastructure.jpa.masters.city;

import lombok.Data;
import lombok.NoArgsConstructor;
import pearls.com.infrastructure.jpa.masters.state.StateData;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name="city")
public class CityData {
    @Id
    private Long code;
    private String description;
    @ManyToOne
    @JoinColumn(name="state")
    private StateData state;
}
