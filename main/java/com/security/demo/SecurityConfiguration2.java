package com.security.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

//for jdbc related
@EnableWebSecurity
public class SecurityConfiguration2 extends WebSecurityConfigurerAdapter {


  @Autowired
  DataSource dataSource;



  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception{
    auth.jdbcAuthentication()
        .dataSource(dataSource)
        .usersByUsernameQuery("select username,password,enabled "
        + "from users "
        + "where username = ?")
        .authoritiesByUsernameQuery("select username,authority "
        + "from authorities "
        + "where username = ?");
//
//        .withDefaultSchema()
//        .withUser {
//      User.withUsername("user")
//          .password("pass")
//          .roles("USER")
//    }
//    .withUser {
//      User.withUsername("user")
//        .password("pass")
//        .roles("ADMIN")
  };


    @Bean
    public PasswordEncoder getPasswordEncoder() {
      return NoOpPasswordEncoder.getInstance();
    }



    @Override
  protected void configure(HttpSecurity httpSec) throws Exception{
    httpSec.authorizeRequests()
        //mapping users specific to their role
        .antMatchers("/admin").hasRole("ADMIN")
        .antMatchers("/user").hasRole("USER")
        .antMatchers("/").permitAll()
        .and().formLogin();

  }

  }

