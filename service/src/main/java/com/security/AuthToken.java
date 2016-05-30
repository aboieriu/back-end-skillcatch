package com.security;


public class AuthToken {
    private final Long userId;
    private final String token;

    public AuthToken(Long userId, String token) {
        this.userId = userId;
        this.token = token;
    }

    public String getToken(){
        return this.token;
    }

    public Long getUserId() {
        return userId;
    }
}
