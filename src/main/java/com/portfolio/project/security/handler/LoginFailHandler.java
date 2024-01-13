package com.portfolio.project.security.handler;

import java.io.IOException;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Component
public class LoginFailHandler implements AuthenticationFailureHandler{

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
            AuthenticationException exception) throws IOException, ServletException {
                //로그인 실패시 다시 로그인 페이지로 전환
                //추가 설정 가능
                response.sendRedirect("/login/page");
                log.info("LOGIN FAIL");
        
    }
    
}
