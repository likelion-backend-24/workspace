package org.example.securityexam4.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.securityexam4.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
@Slf4j
public class UserController {
    private final UserService userService;

//    회원가입을 한다면??  1. 회원가입폼 주세요.
    @GetMapping("/register")
    public String signup(){
        return "signup";
    }


//    2. 회원가입해주세요.
    @PostMapping("/register")
    public String join(){

        return "";
    }



}
