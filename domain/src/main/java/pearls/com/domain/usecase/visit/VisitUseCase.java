package pearls.com.domain.usecase.visit;

import lombok.RequiredArgsConstructor;
import pearls.com.domain.model.visit.Visit;
import pearls.com.domain.usecase.customer.port.CustomerRepository;
import pearls.com.domain.usecase.visit.port.VisitRepository;

import java.util.List;

@RequiredArgsConstructor
public class VisitUseCase {

    private final VisitRepository visitRepository;

    public List<Visit> getVisitsByCustomerId(String nit) {
        return visitRepository.getVisitByCustomerId(nit);
    }

    public String saveVisit(Visit visit) {
        String response = visitRepository.saveVisit(visit);
        return response;
    }
}
