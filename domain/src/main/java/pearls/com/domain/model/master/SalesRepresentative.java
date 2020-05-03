package pearls.com.domain.model.master;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@JsonSerialize
public class SalesRepresentative {
    private Long code;
    private String name;
}
