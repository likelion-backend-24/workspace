package org.example.swaggerexam.controller;

import lombok.RequiredArgsConstructor;
import org.example.swaggerexam.dto.RegisterRequestDto;
import org.example.swaggerexam.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;

    @GetMapping("/welcome")
    public String welcome(){
        return "welcome";
    }

    @GetMapping("/test")
    public String test(){
        return "test";
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequestDto requestDto){


        String message = userService.register(requestDto.getEmail(), requestDto.getPassword());
        return ResponseEntity.ok(message);
    }

//    welcome,  test, register
}
