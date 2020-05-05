package pearls.com.domain.model.visit;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Visit {
    private String customer;
    private String date;
    private Long salesRepresentative;
    private double net;
    private double visitTotal;
    private String description;
    private String city;
}
