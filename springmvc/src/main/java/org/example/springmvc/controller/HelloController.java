package org.example.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("/hi")
    public String hello(){
        return "welcome";
    }
    @GetMapping("/hispring")
    public String hiSpring(){
        return "spring";
    }
    @GetMapping("/rest")
    @ResponseBody
    public String rest(){
        return "Hello rest!!!";
    }
}
