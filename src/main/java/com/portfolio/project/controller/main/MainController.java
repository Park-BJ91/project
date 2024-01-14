package com.portfolio.project.controller.main;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Controller
/* 임시 코드 삭제 수정 OK */
public class MainController {

    @GetMapping("/main/home")
    public String logSuccess(HttpServletRequest request,Model model){

        model.addAttribute("Dummy","Dummy_Data");

        return "user/home";
    }


}
