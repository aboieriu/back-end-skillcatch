package com.endpoint;

import com.security.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashSet;
import java.util.Set;

@RequestMapping( value = "/authenticate/",method = RequestMethod.POST)
@ResponseBody
public class AuthenticationResource {
    private AuthenticationManager authManager;
    private UserAuth userDetailsService;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    @RequestMapping(value = "")

    public AuthToken getUsers(@RequestBody UserCandidate userCandidate){
        String password=userCandidate.getPassword();
        PasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
        passwordEncoder.encode(password);

        UsernamePasswordAuthenticationToken authenticationToken =  new UsernamePasswordAuthenticationToken(userCandidate.getUsername(), password);
        Authentication authentication = this.authManager.authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);



        UserDetails userDetails = this.userDetailsService.loadUserByUsername(userCandidate.getUsername());
        return new AuthToken(TokenUtils.createToken(userDetails));




    }



    public void setAuthManager(AuthenticationManager authManager) {
        this.authManager = authManager;
    }

    public void setUserDetailsService(UserAuth userDetailsService) {
        this.userDetailsService = userDetailsService;
    }
}

