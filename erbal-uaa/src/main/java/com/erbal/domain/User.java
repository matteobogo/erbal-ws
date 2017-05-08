package com.erbal.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.validation.constraints.NotNull;
import java.util.Collection;

@Document(collection = "users")
@Data
@NoArgsConstructor
public class User {

  @Id
  private String id;

  @Indexed
  @NotNull(message = "Email is required")
  @NotBlank(message = "Email is required")
  private String email;

  @JsonIgnore
  @NotNull(message = "Password is required")
  @NotBlank(message = "Password is required")
  private String passwordHash;

  @NotNull(message = "Firstname is required")
  @NotBlank(message = "Firstname is required")
  private String firstname;

  @NotNull(message = "Lastname is required")
  @NotBlank(message = "Lastname is required")
  private String lastname;

  @NotNull(message = "Greenhouse Name is required")
  @NotBlank(message = "Greenhouse Name is required")
  private String greenhouseName;

  @NotNull
  private Collection<String> roles;
}