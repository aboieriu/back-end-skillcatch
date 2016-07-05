package com.endpoint;

import com.security.UserCandidate;
import com.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import view.LoggedUserView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
public class AuthenticationResource extends BaseService  {

    @Autowired
    @Qualifier("authenticationManager")
    private AuthenticationManager authManager;

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    @ResponseBody
    public void authenticateUser(@RequestBody UserCandidate userCandidate){
        String password=userCandidate.getPassword();
        PasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
        passwordEncoder.encode(password);

        UsernamePasswordAuthenticationToken authenticationToken =  new UsernamePasswordAuthenticationToken(userCandidate.getUsername(), password);
        Authentication authentication = this.authManager.authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    @RequestMapping(value="/logout", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public void destroyUserSession(HttpServletRequest request) throws Exception {
        HttpSession session = request.getSession(false);
        session.invalidate();
    }

    public void setAuthManager(AuthenticationManager authManager) {
        this.authManager = authManager;
    }
}