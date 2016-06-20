package com.service;


import com.exception.NoLoggedUser;
import com.handler.RestError;
import com.security.AuthenticationContext;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

/**
 * Created by icringanu on 11.03.2016.
 */
public class BaseService {

    public Long getLoggedUserId() throws Exception{
        Optional<Long> loggedUserId = AuthenticationContext.getLoggedInUserId();
        if (!loggedUserId.isPresent()) {
            throw new NoLoggedUser();
        }
        return loggedUserId.get();
    }

    @ExceptionHandler(TypeMismatchException.class)
    public ModelAndView handleTypeExceptions(HttpServletResponse response, TypeMismatchException ex) throws Exception{

       RestError re=new RestError(HttpStatus.BAD_REQUEST,400,"Type Mismatch!Please insert compatible types!","Type Mismatch!Please insert compatible types!","",ex);
       response.setStatus(400);
        ModelAndView modelAndView=new ModelAndView();
       modelAndView.addObject("status:",response.getStatus());
        modelAndView.addObject("code:",response.getStatus());
        modelAndView.addObject("message:",re.getMessage());
        modelAndView.addObject("developerMessage:",re.getDeveloperMessage());
        return modelAndView;
    }

    @ExceptionHandler(NoLoggedUser.class)
    public ModelAndView handleNoLoggedUser(HttpServletResponse response, NoLoggedUser ex) throws Exception{

        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("status:",response.getStatus());
        modelAndView.addObject("code:",response.getStatus());
        modelAndView.addObject("message:","No logged in user");
        modelAndView.addObject("developerMessage:","");
        return modelAndView;
    }

    @ExceptionHandler(AuthenticationException.class)
    @ResponseBody
    public ModelAndView handleAuthenticationException(HttpServletResponse response, NoLoggedUser ex) {
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("status:",response.getStatus());
        modelAndView.addObject("code:",response.getStatus());
        modelAndView.addObject("message:","You are unauthorised to access this resource");
        modelAndView.addObject("developerMessage:", "");
        return modelAndView;
    }

    @ExceptionHandler(InsufficientAuthenticationException.class)
    @ResponseBody
    public ModelAndView handleInsufficientAuthenticationException(HttpServletResponse response, NoLoggedUser ex) {
        response.setStatus(HttpStatus.FORBIDDEN.value());
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("status:",response.getStatus());
        modelAndView.addObject("code:",response.getStatus());
        modelAndView.addObject("message:","You are unauthorised to access this resource");
        modelAndView.addObject("developerMessage:", "");
        return modelAndView;
    }
}
