package com.erbal.service;

import com.erbal.domain.security.CurrentUser;
import com.erbal.domain.User;
import com.erbal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CurrentUserDetailsService implements UserDetailsService {

  private UserRepository userRepository;

  @Autowired
  public CurrentUserDetailsService(UserRepository userRepository) {

    this.userRepository = userRepository;
  }

  @Override
  public CurrentUser loadUserByUsername(String email) throws UsernameNotFoundException {

    User user = userRepository.findByEmail(email);

    if (user == null) {
      throw new UsernameNotFoundException(email);
    }

    return new CurrentUser(user);
  }
}