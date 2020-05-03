package pearls.com.infrastructure.jpa.visit;

import org.springframework.stereotype.Repository;
import pearls.com.domain.model.visit.Visit;
import pearls.com.domain.usecase.visit.port.VisitRepository;
import pearls.com.infrastructure.jpa.common.AdapterOperations;
import pearls.com.infrastructure.jpa.common.MapperUtil;
import pearls.com.infrastructure.jpa.customer.CustomerData;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class VisitDataRepositoryAdapter extends AdapterOperations<VisitData, Long, VisitDataRepository> implements VisitRepository {

    private static final String VISIT_CREATED_SUCCESSFULLY = "Visit created succesfully";

    public VisitDataRepositoryAdapter(VisitDataRepository repository) {
        super(repository);
    }

    @Override
    public List<Visit> getVisitByCustomerId(String nit) {
        CustomerData customerData = new CustomerData();
        customerData.setNit(nit);
        return this.repository.findByIdcustomer(customerData).stream().map(visitData -> MapperUtil.mapVisit(visitData)).collect(Collectors.toList());
    }

    @Override
    public String saveVisit(Visit visit) {
        this.save(MapperUtil.mapVisitData(visit));
        return  VISIT_CREATED_SUCCESSFULLY;
    }
}
