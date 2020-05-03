package pearls.com.domain.model.master;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Country {
    private Long code;
    private String description;
}
