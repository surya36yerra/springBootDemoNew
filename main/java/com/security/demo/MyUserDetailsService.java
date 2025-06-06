package com.security.demo;

import com.security.demo.models.MyUserDetails;
import com.security.demo.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

public class MyUserDetailsService implements UserDetailsService {


  @Autowired
  UserRepository userRepository;

  @Service
  public UserDetails loadUserByUserName(String userName) throws UsernameNotFoundException {
    Optional<User> user = userRepository.findByUserName(userName);
    user.orElseThrow(()->new UsernameNotFoundException("not found::"+userName));
    return user.map(MyUserDetails::new).get();
  }



}
