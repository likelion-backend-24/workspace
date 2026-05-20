package org.example.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CaramiController {
    @GetMapping("/hi2")
    public String hi(){
        return "welcome";
    }
}
