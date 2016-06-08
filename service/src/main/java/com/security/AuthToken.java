package com.security;


import model.Role;

import java.util.Set;

public class AuthToken {
    private final Long userId;
    private final String token;
    private final Set<Role> userRole;

    public AuthToken(Long userId, String token,Set<Role> userRole) {
        this.userId = userId;
        this.token = token;
        this.userRole=userRole;
    }

    public String getToken(){
        return this.token;
    }

    public Long getUserId() {
        return userId;
    }

    public Set<Role> getUserRole() {
        return userRole;
    }
}
