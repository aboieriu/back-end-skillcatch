package com.service;


import com.exception.NoLoggedUser;
import com.security.AuthenticationContext;
import org.springframework.http.HttpStatus;
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
}
