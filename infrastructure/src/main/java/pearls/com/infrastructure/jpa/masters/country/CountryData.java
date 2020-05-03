package pearls.com.infrastructure.jpa.masters.country;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@NoArgsConstructor
@Table(name="country")
public class CountryData{
    @Id
    private Long code;
    private String description;
}
