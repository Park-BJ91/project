package com.portfolio.project.security.handler;

import java.io.IOException;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class LoginSuccessHandler implements AuthenticationSuccessHandler{

    /* 로그인에 성공 했을때 핸들링 */
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) throws IOException, ServletException {

                log.info("SUCCESS HANDLER");
                log.info(authentication.getName());
         
            HttpSession session = request.getSession();
            session.setAttribute("user", authentication.getPrincipal());
            session.setAttribute("name", authentication.getName());

            response.sendRedirect("/main/home"); 
        
    }

}
