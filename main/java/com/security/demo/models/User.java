package com.security.demo.models;


import javax.persistence.*;

@Entity
@Table(name = "User")
public class User {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int id;
private String name;
private String password;
private String active;
private String roles;




}
