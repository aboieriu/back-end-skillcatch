package com.exhandler;

import com.handler.DefaultRestErrorResolver;
import com.handler.RestError;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.MediaType;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.access.AccessDeniedHandlerImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Default controller that exists to return a proper REST response for unmapped requests.
 */
@Controller
public  class DefaultController  {

    @RequestMapping("/**")
    public void unmappedRequest(HttpServletRequest request,HttpServletResponse response) throws IOException {


        String uri = request.getRequestURI();
            throw new UnknownResourceException("There is no resource for " + uri);

    }
    @RequestMapping("/authenticate/")
    public void unsupported(HttpServletRequest request) {
        String uri = request.getRequestURI();
        throw new Unsupported("Unsupported  " + uri);
    }

    }



