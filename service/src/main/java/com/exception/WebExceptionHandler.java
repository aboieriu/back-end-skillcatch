package com.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by aboieriu on 6/29/16.
 */
@ControllerAdvice
public class WebExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(WebExceptionHandler.class);

    @ExceptionHandler(NoLoggedUser.class)
    @ResponseBody
    public ResponseEntity<ErrorView> handleNoLoggedUser(HttpServletResponse response, NoLoggedUser ex) throws Exception{
        return handleException(HttpStatus.UNAUTHORIZED, ex);
    }

    @ExceptionHandler(AuthenticationException.class)
    @ResponseBody
    public ResponseEntity<ErrorView> handleAuthenticationException(HttpServletResponse response, Exception ex) {
        return handleException(HttpStatus.UNAUTHORIZED, ex);
    }

    @ExceptionHandler(InsufficientAuthenticationException.class)
    @ResponseBody
    public ResponseEntity<ErrorView> handleInsufficientAuthenticationException(HttpServletResponse response, Exception ex) {
        return handleException(HttpStatus.UNAUTHORIZED, ex);
    }

    @ExceptionHandler(Throwable.class)
    @ResponseBody
    public ResponseEntity<ErrorView> exceptionGeneric(HttpServletResponse response, Exception ex) {
        return handleException(HttpStatus.INTERNAL_SERVER_ERROR, ex);
    }

    private ResponseEntity<ErrorView> handleException(HttpStatus status, Throwable ex){
        logger.error("Exception details: ", ex);
        return new ResponseEntity<ErrorView>(prepareErrorView(status, ex.getMessage()), status);
    }

    protected ErrorView prepareErrorView(HttpStatus statusCode, String errorCode){
        return new ErrorView(statusCode.toString(), errorCode);
    }
}
