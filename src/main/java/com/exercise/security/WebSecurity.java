package com.exercise.security;

import com.exercise.security.filter.AuthenticationFilter;
import com.exercise.security.user.UserDetailsServiceImpl;
import com.exercise.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

//@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    private UserService userService;
    private BCryptPasswordEncoder enconder;

    public WebSecurity(BCryptPasswordEncoder enconder,
                       UserService userService) {
        this.enconder = enconder;
        this.userService = userService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        AuthenticationFilter authenticationFilter = new AuthenticationFilter(authenticationManager(), userService);

        http.addFilterBefore(authenticationFilter, AbstractAuthenticationProcessingFilter.class)
                .csrf().disable().authorizeRequests()
                .anyRequest().authenticated();
    }



    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(enconder);
    }
}