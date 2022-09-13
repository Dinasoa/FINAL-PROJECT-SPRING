package com.example.project.security.model;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    USER ,
    ADMIN ;

    public String getRole(){
        return name();
    }
    @Override
    public String getAuthority() {
        return "ROLE_" + getRole();
    }

    @Override
    public String toString() {
        return this.name();
    }
}
