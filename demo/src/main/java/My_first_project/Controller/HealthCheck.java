package My_first_project.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheck {
    @GetMapping("/health-check")//iss url endpoint par yeh function chalega get
    //call kay sath
    public String method(){
        return "ok";
    }
}
