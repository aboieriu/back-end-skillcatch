package com.exhandler;

import org.springframework.security.web.access.AccessDeniedHandler;

/**
 * Simulated business-logic exception indicating a desired business entity or record cannot be found.
 */
public class UnknownResourceException extends RuntimeException  {

    public UnknownResourceException(String msg) {
        super(msg);
    }
}
