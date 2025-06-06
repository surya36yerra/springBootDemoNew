package com.security.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.User;

public interface UserRepository extends JpaRepository<User,Integer>
  Optional<User> findUserByName(String userName);
}


