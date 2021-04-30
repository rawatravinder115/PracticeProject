package com.example.testJDBC.demo.practiceJDBC;

import com.example.testJDBC.demo.practiceJDBC.DAOs.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

		Person person1 = new Person(1,"ravi",18,11,"delhi");
		Person person2 = new Person(2,"kavi",8,10,"punjab");
//		person.add
	}

}
