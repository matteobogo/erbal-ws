package com.erbal.domain.security;

import com.erbal.domain.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.security.core.authority.AuthorityUtils;

import java.util.Collection;

@EqualsAndHashCode(callSuper = true)
@Data
public class CurrentUser extends org.springframework.security.core.userdetails.User {

  private String id;
  private String firstname;
  private String lastname;

  public CurrentUser(User user) {

    super(user.getEmail(), user.getPasswordHash(), AuthorityUtils.createAuthorityList(getRoles(user.getRoles())));

    this.id = user.getId();
    this.firstname = user.getFirstname();
    this.lastname = user.getLastname();
  }

  private static String[] getRoles(Collection<String> roles) {

    String[] rolesArray = new String[roles.size()];
    roles.toArray(rolesArray);

    return rolesArray;
  }
}