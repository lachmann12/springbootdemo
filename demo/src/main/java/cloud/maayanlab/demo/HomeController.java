package cloud.maayanlab.demo;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@CrossOrigin
public class HomeController {
    
    @GetMapping(value="/demo")
    public List<String> home() {
        return List.of("Hello","from Spring Boot");
    }
}
