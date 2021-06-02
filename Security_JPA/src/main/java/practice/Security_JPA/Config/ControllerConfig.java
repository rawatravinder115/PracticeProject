package practice.Security_JPA.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import practice.Security_JPA.Entity.MyUserDetailsServices;
import practice.Security_JPA.Entity.UserRepository;

@EnableWebSecurity
public class ControllerConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    MyUserDetailsServices service;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(service);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
       http.
               httpBasic()
               .and()
               .authorizeRequests()
               .antMatchers("/admin/**").hasAuthority("admin")
               .antMatchers("/employee/**").hasAnyAuthority("admin","employee")
               .antMatchers("/**").permitAll()
               .and()
               .formLogin();
    }

    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
