package com.portfolio.project.controller.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class LoginController {
    @GetMapping("/login/page")
    public String loginPage(){

        log.info("로그인 페이지 접속");

        return "login/loginPage";
    }

    @PostMapping("/login/post")
    public String postLog(){
        log.info("POST 확인");
        return "POST";
    }


}
