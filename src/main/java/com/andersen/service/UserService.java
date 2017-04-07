package com.andersen.service;

import com.andersen.domain.Role;
import com.andersen.domain.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;


public class UserService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return User.builder()
                .username(username)
                .password("123")
                .authorities(Collections.singletonList(Role.ADMIN))
                .isAccountNonExpired(true)
                .isAccountNonLocked(true)
                .isCredentialsNonExpired(true)
                .isEnabled(true)
                .build();
    }
}