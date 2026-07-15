package org.example.springapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String home() {
        return "Hello from AWS EC2!";
    }

    @GetMapping("/health")
    public String health() {
        return "OK";
    }
}