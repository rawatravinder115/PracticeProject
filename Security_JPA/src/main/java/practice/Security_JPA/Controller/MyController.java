package practice.Security_JPA.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {


    @GetMapping("/employee")
    public String employee(){
        return "<h1>hello employee </h1>";
    }

    @GetMapping("/admin")
    public String admin(){
        return "<h1> hello admin , good morning </h1>";
    }

    @GetMapping("/visitor")
    public String visitor(){
        return "<h1> hello visitor , welcome to our company </h1>";
    }
}
