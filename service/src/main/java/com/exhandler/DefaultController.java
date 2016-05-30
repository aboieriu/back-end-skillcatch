package com.exhandler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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



