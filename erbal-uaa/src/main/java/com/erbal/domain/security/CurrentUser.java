package com.erbal.domain.security;

import com.erbal.domain.User;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.security.core.authority.AuthorityUtils;

import java.util.Collection;

@Data
@EqualsAndHashCode(callSuper = false)
public class CurrentUser extends org.springframework.security.core.userdetails.User {

  private String firstname;
  private String lastname;
  private String greenhouseName;

  public CurrentUser(User user) {

    super(user.getEmail(), user.getPasswordHash(), AuthorityUtils.createAuthorityList(getRoles(user.getRoles())));

    this.firstname = user.getFirstname();
    this.lastname = user.getLastname();
    this.greenhouseName = user.getGreenhouseName();
  }

  private static String[] getRoles(Collection<String> roles) {

    String[] rolesArray = new String[roles.size()];
    roles.toArray(rolesArray);

    return rolesArray;
  }
}