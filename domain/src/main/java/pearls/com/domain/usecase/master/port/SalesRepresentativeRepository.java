package pearls.com.domain.usecase.master.port;

import pearls.com.domain.model.master.SalesRepresentative;

import java.util.List;

public interface SalesRepresentativeRepository {
    List<SalesRepresentative> getSalesRepresentativeMaster();
}
