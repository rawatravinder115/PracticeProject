package com.example.testJDBC.demo.practiceJDBC.Controller;

import com.example.testJDBC.demo.practiceJDBC.DAOs.Person;
import com.example.testJDBC.demo.practiceJDBC.DBManager.DBOperation;
import com.example.testJDBC.demo.practiceJDBC.Request.CreateRequest;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
public class PersonController {

    @RequestMapping(value= "/getperson",method = RequestMethod.GET)
    public List<Person> getPerson() throws SQLException {
        return DBOperation.getperson();
    }

    // this method is not properly called so always create table by typing this into cmd -->  curl -XPOST "127.0.0.1:8080/{yourtablename}?name=person"

    @RequestMapping(value="/createTable",method=RequestMethod.POST)
    public static void createTable(@RequestParam(value = "name") String name) throws SQLException {
        DBOperation.createTable(name);
    }


    @RequestMapping("/hello")
    public static String hello(){
        return "hello developer";
    }

    @RequestMapping(value="/insert",method= RequestMethod.POST)
    public static void insertPerson(@RequestBody CreateRequest request) throws SQLException {
        DBOperation.insertPerson(request);
    }


//        @RequestMapping("/dev")
//    public static String isDev(@RequestParam(value ="name") String name , @RequestMapping(value = "surname") String surname){
//        return
//    }

    
    @RequestMapping(value ="/getPersonByid",method = RequestMethod.DELETE)
    public static void deletePersonByid(){

    }


}
