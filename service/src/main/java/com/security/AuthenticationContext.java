package com.security;

import org.slf4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.Optional;
import java.util.UUID;

/**
 * Created by aboieriu on 6/20/16.
 */
public class AuthenticationContext {
    private static Logger logger = org.slf4j.LoggerFactory.getLogger(AuthenticationContext.class);

    public static Optional<Long> getLoggedInUserId() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            Object principal = auth.getPrincipal();
            PropertyDescriptor pd = BeanUtils.getPropertyDescriptor(principal.getClass(), "userId");
            Method getter = pd.getReadMethod();
            try {
                return Optional.of((Long) getter.invoke(principal));
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
            }

        }
        return Optional.empty();
    }
}
