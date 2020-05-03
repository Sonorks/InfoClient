package pearls.com.domain.model.visit;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Visit {
    private String customer;
    private Date date;
    private Long salesRepresentative;
    private double net;
    private double visitTotal;
    private String description;
}
