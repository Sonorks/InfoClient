package pearls.com.infrastructure.entrypoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pearls.com.domain.model.master.City;
import pearls.com.domain.model.master.Country;
import pearls.com.domain.model.master.SalesRepresentative;
import pearls.com.domain.model.master.State;
import pearls.com.domain.usecase.master.MasterUseCase;

import java.util.List;

@RestController
@RequestMapping(value="/master", produces = MediaType.APPLICATION_JSON_VALUE)
public class MasterService {

    @Autowired
    private MasterUseCase masterUseCase;

    @GetMapping(value = "/country")
    public List<Country> getCountryMaster(){
        return masterUseCase.getCountryMaster();
    }

    @GetMapping(value = "/state/{country}")
    public List<State> getStateMasterByCountry(@PathVariable("country") Long country){
        return masterUseCase.getStateMasterByCountry(country);
    }

    @GetMapping(value = "/city/{state}")
    public List<City> getCityMasterByState(@PathVariable("state") Long state){
        return masterUseCase.getCityMasterByState(state);
    }

    @GetMapping(value= "/salesrep")
    public List<SalesRepresentative> getSalesRepresentativeMaster(){
        return masterUseCase.getSalesRepresentativeMaster();
    }
}
