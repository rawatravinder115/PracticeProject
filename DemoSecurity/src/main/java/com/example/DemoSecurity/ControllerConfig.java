package com.example.DemoSecurity;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@EnableWebSecurity
public class ControllerConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().
                withUser("ravi")
                .password("ravi")
                .roles("employee")
                .and()
                .withUser("kavi")
                .password("kavi")
                .roles("admin");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.
                authorizeRequests()
                .antMatchers("/employee/**").hasRole("employee")
                .antMatchers("/admin/**").hasAnyRole("admin","employee")
                .antMatchers("/visitor**").permitAll()
                .and()
                .formLogin();
    }
}
