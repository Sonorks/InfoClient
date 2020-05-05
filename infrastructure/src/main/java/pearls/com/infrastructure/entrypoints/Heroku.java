package pearls.com.infrastructure.entrypoints;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value="/", produces = MediaType.APPLICATION_JSON_VALUE)
public class Heroku {

    @GetMapping()
    public String herokuHealth(){
        return "ok";
    }
}
