package com.security.jwt;

import com.security.demo.UserRepository;
import com.security.demo.models.MyUserDetails;
import com.security.demo.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

public class MyUserDetailsService implements UserDetailsService {


  @Autowired
  UserRepository userRepository;

  @Service
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    return new User("foo","foo",new ArrayList<>());
  }
}
