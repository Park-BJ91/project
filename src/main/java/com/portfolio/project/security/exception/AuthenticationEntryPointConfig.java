package com.portfolio.project.security.exception;

import java.io.IOException;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class AuthenticationEntryPointConfig implements AuthenticationEntryPoint{

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
            AuthenticationException authException) throws IOException, ServletException {

                log.info("EntryPoint Req :" + request);
                log.info("EntryPoint Res :" + response);
                log.info("EntryPoint Authenication Execption :" + authException);

                response.sendError(HttpServletResponse.SC_UNAUTHORIZED,"401에러");
        
        
    }
    
}
