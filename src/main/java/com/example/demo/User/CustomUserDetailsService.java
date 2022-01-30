package com.example.demo.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;

public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (userService.findByUsername(username).isPresent()) {
            UserTable user = userService.findByUsername(username).get();
            return new User(user.getName(), user.getPassword(), new ArrayList<>());

        }
        throw new UsernameNotFoundException("User not found with username: " + username);


    }

}
