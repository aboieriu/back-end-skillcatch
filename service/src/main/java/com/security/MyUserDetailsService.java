package com.security;



import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class MyUserDetailsService implements UserDetailsService {


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Set<String> roles = new HashSet<String>();
        roles.add("ROLE_DEV");
        // add user fetching logic here
        //$2a$04$hUzLRs8z9MbnbL0SbC/iaOMXQIbdW1/5DjpEcMu3XKK5qF4zizzyy is encoded password for "admin1"
        return new UserDetailsImpl("Ionut", "$2a$04$hUzLRs8z9MbnbL0SbC/iaOMXQIbdW1/5DjpEcMu3XKK5qF4zizzyy", roles);
    }
}
