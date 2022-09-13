//package com.example.project.security.model;
//import com.example.project.model.User;
//import lombok.AllArgsConstructor;
//import lombok.ToString;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Component;
//
//import java.util.Collection;
//import java.util.List;
//
//@AllArgsConstructor
//@ToString
//public class AppUserDetails implements UserDetails {
//
//    private User user ;
//
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return List.of(user.getRole());
//    }
//
//    @Override
//    public String getPassword() {
//        return user.getPassword();
//    }
//
//    @Override
//    public String getUsername() {
//        return user.getUsername();
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return false;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return false;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return false;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return user.isEnabled();
//    }
//}
