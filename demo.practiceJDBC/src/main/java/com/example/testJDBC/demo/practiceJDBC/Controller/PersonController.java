package com.example.testJDBC.demo.practiceJDBC.Controller;

import com.example.testJDBC.demo.practiceJDBC.DAOs.Person;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonController {

    @RequestMapping("/getperson")
    public List<Person> getPerson(){
        return
    }
}
