package com.security.oAuth;

import com.security.demo.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;



  @SpringBootApplication
  @EnableJpaRepositories(basePackageClasses = UserRepository.class)
  public class FacebookLoginApplication {

    public static void main(String[] args) {

      SpringApplication.run(com.security.demo.SecurityDemoApplication.class, args);
    }



  }
}
