package com.security.ldap;

import com.security.demo.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class SecurityLDAPApplication {

	public static void main(String[] args) {

		SpringApplication.run(SecurityLDAPApplication.class, args);
	}



}
