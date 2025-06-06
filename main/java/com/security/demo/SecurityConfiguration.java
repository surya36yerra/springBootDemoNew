package com.security.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception{
    auth.inMemoryAuthentication()
        .withUser("blah")
        .password("blah")
        .roles("USER")
        .and()//to chain users
        .withUser("blah2")
        .password("blah2")
        .roles("USER2");
  }






  @Bean
  public PasswordEncoder getPasswordEncoder() {
    return NoOpPasswordEncoder.getInstance();
  }

  @Override
      protected void configure(HttpSecurity httpSec) throws Exception{
      httpSec.authorizeRequests()
          .antMatchers("/**").hasRole("user")
          .antMatchers("/**").hasAnyRole("Admin","_")
          .antMatchers("/","static/css","static/js").permitAll()
          .and().formLogin()

      //mapping users specific to their role
        .antMatchers("/admin").hasRole("ADMIN")
        .antMatchers("/user").hasRole("USER")
        .antMatchers("/").permitAll()
        .and().formLogin();

  }

  }
}
