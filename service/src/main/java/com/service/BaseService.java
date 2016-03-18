package com.service;


import com.handler.RestError;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by icringanu on 11.03.2016.
 */
public class BaseService {

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
}
