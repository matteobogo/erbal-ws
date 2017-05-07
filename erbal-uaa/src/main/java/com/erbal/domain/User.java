package com.erbal.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Document(collection = "users")
@Data
@NoArgsConstructor
public class User {

  @Id
  private String id;
  private String email;
  @JsonIgnore
  private String passwordHash;
  private String firstname;
  private String lastname;
  private String greenhouseName;
  private Collection<String> roles;
}