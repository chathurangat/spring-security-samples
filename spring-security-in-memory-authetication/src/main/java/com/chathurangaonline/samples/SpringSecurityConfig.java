package com.chathurangaonline.samples;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    public void configureAuthenticationManagerBuilder(AuthenticationManagerBuilder builder) throws Exception {
        builder.inMemoryAuthentication().withUser("user").password("123").roles("USER");
        builder.inMemoryAuthentication().withUser("admin").password("123").roles("ADMIN");
        builder.inMemoryAuthentication().withUser("super_user").password("123").roles("USER","ADMIN");
    }

    //authorization
    public void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests()
                .antMatchers("/", "/home").permitAll()
                .antMatchers("/user/**").access("hasRole('USER')")
                .antMatchers("/admin/**").access("hasRole('ADMIN')")
                .antMatchers("/super-user/**").access("hasRole('USER') and hasRole('ADMIN')")
                .and().formLogin()
                .and().exceptionHandling().accessDeniedPage("/access_denied");
    }
}
