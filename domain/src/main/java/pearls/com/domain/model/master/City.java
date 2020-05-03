package pearls.com.domain.model.master;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class City {
    private Long code;
    private String description;
    private Long state;
}
