package com.portfolio.project.security.user;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;

@Data
public class UserDetailCustom implements UserDetails{
    private String USER_ID;
    private String USER_PW;
    private Collection<? extends GrantedAuthority> authorities;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
            
        return USER_PW;
    }

    @Override
    public String getUsername() {
        
        return USER_ID;
    }

    @Override
    //계정 만료
    public boolean isAccountNonExpired() {
        
        return true;
    }

    @Override
    //잠김
    public boolean isAccountNonLocked() {
        
        return true;
    }

    @Override
    //비밀번호 만료
    public boolean isCredentialsNonExpired() {
        
        return true;
    }

    @Override
    //활성 상태
    public boolean isEnabled() {
        
        return true;
    }



    
}
