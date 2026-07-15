package org.example.todoapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/loop")
    public String loop(){
        while(true){
//            무한루프!!
        }
    }

    @GetMapping("/sleep")
    public String sleep() throws InterruptedException{
        Thread.sleep(10000);
        return "Wake up!!";
    }
}
