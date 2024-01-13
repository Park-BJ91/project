package com.portfolio.project.service.login;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.project.security.mapper.LoginMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class LoginService {

    @Autowired
    private LoginMapper loginMapper;

    public Map<String,String> loginCheck(){

        Map<String,String> loginInfo = loginMapper.loginCheck();
        log.info("DB에 있는 로그인 정보" +loginInfo);

        return null;
    }

}
