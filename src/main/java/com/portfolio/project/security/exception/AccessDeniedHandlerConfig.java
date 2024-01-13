package com.portfolio.project.security.exception;

import java.io.IOException;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class AccessDeniedHandlerConfig implements AccessDeniedHandler{

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response,
            AccessDeniedException accessDeniedException) throws IOException, ServletException {
        
                log.info("DeniedHandler Req :" + request);
                log.info("DeniedHandler Res :" + response);
                log.info("DeniedHandler AccessDeniedException :" + accessDeniedException);

                response.sendError(HttpServletResponse.SC_FORBIDDEN,"403에러");
        
    }
    
}
