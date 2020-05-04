package pearls.com.domain.usecase.visit.port;

import pearls.com.domain.model.visit.Visit;

import java.util.List;

public interface VisitRepository {
    List<Visit> getVisitByCustomerId(String nit);
    String saveVisit(Visit visit);

    List<Visit> getAllVisits();
}
