package com.example.DemoSecurity;

import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@EnableWebSecurity
public class ControllerConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().
                withUser("ravi")
                .password("root")
                .roles("role_employee")
                .and()
                .withUser("ravinder")
                .password("ravi")
                .roles("role_admin");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.
                httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers("/admin/**").hasRole("role_admin") // in this role based system
                .antMatchers("/employee/**").hasAnyRole("role_employee","role_admin")
                .antMatchers("/**").permitAll()
                .and()
                .formLogin();
    }

    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }
}
