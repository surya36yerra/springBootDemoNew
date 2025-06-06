package com.security.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

//for JPA related
@EnableWebSecurity
public class SecurityConfiguration3 extends WebSecurityConfigurerAdapter {


  @Autowired
  DataSource dataSource;


  @Autowired
  UserDetailsService userDetailsService;

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception{
    auth.userDetailsService(userDetailsService);
  };

  @Override
  protected void configure(HttpSecurity httpSec) throws Exception{
    httpSec.authorizeRequests()
        //mapping users specific to their role
        .antMatchers("/admin").hasRole("ADMIN")
        .antMatchers("/user").hasRole("ADMIN","USER")
        .antMatchers("/").permitAll()
        .and().formLogin();
  }

  @Bean
  public PasswordEncoder getPasswordEncoder() {
    return NoOpPasswordEncoder.getInstance();
  }






    @Bean
    public PasswordEncoder getPasswordEncoder() {
      return NoOpPasswordEncoder.getInstance();
    }





  }

