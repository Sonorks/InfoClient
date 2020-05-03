package pearls.com.infrastructure.jpa.masters.salesrepresentative;

import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;
import pearls.com.domain.model.master.SalesRepresentative;
import pearls.com.domain.usecase.master.port.SalesRepresentativeRepository;
import pearls.com.infrastructure.jpa.common.AdapterOperations;
import pearls.com.infrastructure.jpa.common.MapperUtil;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class SalesRepDataRepositoryAdapter extends AdapterOperations<SalesRepData, Long, SalesRepDataRepository> implements SalesRepresentativeRepository {
    public SalesRepDataRepositoryAdapter(SalesRepDataRepository repository, ObjectMapper mapper) {
        super(repository);
    }

    @Override
    public List<SalesRepresentative> getSalesRepresentativeMaster() {
        return this.getAll().stream().map(salesRepData -> MapperUtil.mapSalesRep(salesRepData)).collect(Collectors.toList());
    }
}
