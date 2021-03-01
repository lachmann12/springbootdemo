package cloud.maayanlab.demo;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@CrossOrigin
public class HomeController {
    
    @GetMapping(value="/demo")
    public List<String> home() {
        return List.of("Hello","from Spring Boot");
    }

    @GetMapping(value="/")
    public List<String> home2() {
        return List.of("Hello","from Spring Boot");
    }
}
