package com.endpoint;

import com.security.MyUserDetailsService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.security.AuthToken;
import com.security.TokenUtils;

import com.security.UserCandidate;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping( value = "/login/",method = RequestMethod.POST)
@ResponseBody
public class AuthenticationResource {
    private AuthenticationManager authManager;
    private MyUserDetailsService userDetailsService;

    @RequestMapping(value = "")

    public AuthToken getUsers(@RequestBody UserCandidate userCandidate){
        UsernamePasswordAuthenticationToken authenticationToken =  new UsernamePasswordAuthenticationToken(userCandidate.getUsername(), userCandidate.getPassword());
        Authentication authentication = this.authManager.authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        UserDetails userDetails = this.userDetailsService.loadUserByUsername(userCandidate.getUsername());

        return new AuthToken(TokenUtils.createToken(userDetails));
    }

    public void setAuthManager(AuthenticationManager authManager) {
        this.authManager = authManager;
    }

    public void setUserDetailsService(MyUserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }
}

