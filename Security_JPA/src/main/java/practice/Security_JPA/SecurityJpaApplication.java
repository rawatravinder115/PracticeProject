package practice.Security_JPA;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import practice.Security_JPA.Entity.User;
import practice.Security_JPA.Entity.UserRepository;

@SpringBootApplication
public class SecurityJpaApplication  implements CommandLineRunner {

	@Autowired
	UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(SecurityJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String p1 = "ravi123";
		String p2 = "root123";

		String encodedpassword1 = passwordEncoder.encode(p1);
		String encodedpassword2 = passwordEncoder.encode(p2);

//
		User u1 =  new User("ravinder",encodedpassword1,true,"admin:employeee"); // password = ravi
		User u2 = new User("ravi",encodedpassword2,true,"employee"); // password = root

	  userRepository.save(u1);
	  userRepository.save(u2);



//		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//		String pass = "ravi";
//		String encodedPassword= passwordEncoder.encode(pass);
//
//		System.out.println();
//		System.out.println("password is : " + pass);
//		System.out.println("Encoded password is : " + encodedPassword);
//		System.out.println();
//
//		boolean ispasswordMatch = passwordEncoder.matches(pass,"");
//		System.out.println("pass : " + pass + "   ispasswordMatch : "+ ispasswordMatch);

	}
}
