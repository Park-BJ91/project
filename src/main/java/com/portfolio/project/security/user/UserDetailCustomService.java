package com.portfolio.project.security.user;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailCustomService implements UserDetailsService{

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    //UserDetailService에서는 클라이언트에게 받은 id를 검색 String username = 사용자가 입력한 ID 
    

    
        return null;
    }
    
}
