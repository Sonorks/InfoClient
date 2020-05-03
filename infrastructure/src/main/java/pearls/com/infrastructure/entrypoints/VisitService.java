package pearls.com.infrastructure.entrypoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pearls.com.domain.model.visit.Visit;
import pearls.com.domain.usecase.visit.VisitUseCase;

import java.util.List;

@RestController
@RequestMapping(value="/visit", produces = MediaType.APPLICATION_JSON_VALUE)
public class VisitService {

    @Autowired
    VisitUseCase visitUseCase;

    @GetMapping(value="/{nit}")
    public List<Visit> getVisitsByCustomerId(@PathVariable("nit") String nit){
        return visitUseCase.getVisitsByCustomerId(nit);
    }

    @PostMapping
    public String saveVisit(@RequestBody Visit visit){
        return visitUseCase.saveVisit(visit);
    }
}
