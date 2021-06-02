package com.example.DemoSecurity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("/visitor")
    public String visitor(){
        return" <h1>hello visitor you dont need authentication</h1> ";
    }

    @GetMapping("/employee")
    public String employee(){
        return "<h1>Hello employee </h1>";
    }

    @GetMapping("/admin")
    public String admin(){
        return "<h1>hello admin<h1>";
    }
}
