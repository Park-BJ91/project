package com.portfolio.project.controller.main;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Controller
public class MainController {

    @GetMapping("/main/home")
    public String logSuccess(HttpServletRequest request){
        //로그인 성공 핸들러에서 Attr에 저장한 세션 정보 가져오기 
        log.info("SESSION : "+request.getSession().getAttribute("user"));
        log.info("LOGIN ID : " + request.getSession().getAttribute("name"));
        //SecurityContextHolder로 가져오기
        //  SecurityContext는 현재 스레드와 관련된 보안정보를 정의
        log.info("NAME : "+SecurityContextHolder.getContext().getAuthentication().getName());

        return "user/home";
    }


}
