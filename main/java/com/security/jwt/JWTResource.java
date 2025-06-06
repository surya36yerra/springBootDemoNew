package com.security.jwt;

import org.springframework.web.bind.annotation.GetMapping;

public class JWTResource {

  @GetMapping("/")
  public String index(){
    return "Home-Page";
  }
}
