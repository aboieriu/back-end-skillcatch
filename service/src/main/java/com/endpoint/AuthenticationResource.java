package com.endpoint;

import com.security.UserCandidate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping( value = "/authenticate/",method = RequestMethod.POST)
@ResponseBody
public class AuthenticationResource {
    private AuthenticationManager authManager;

    @RequestMapping(value = "")
    public void authenticateUser(@RequestBody UserCandidate userCandidate){
        String password=userCandidate.getPassword();
        PasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
        passwordEncoder.encode(password);

        UsernamePasswordAuthenticationToken authenticationToken =  new UsernamePasswordAuthenticationToken(userCandidate.getUsername(), password);
        Authentication authentication = this.authManager.authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    public void setAuthManager(AuthenticationManager authManager) {
        this.authManager = authManager;
    }
}

