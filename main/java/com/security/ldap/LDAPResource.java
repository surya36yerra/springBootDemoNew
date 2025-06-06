package com.security.ldap;

import org.springframework.web.bind.annotation.GetMapping;

public class LDAPResource {

  @GetMapping("/")
  public String index(){
    return "Home-Page";
  }
}
