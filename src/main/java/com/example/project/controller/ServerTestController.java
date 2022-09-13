package com.example.project.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@CrossOrigin

public class ServerTestController {
    @GetMapping("/ping")
    public String ServerTest(){
        return "pong" ;
    }

    @GetMapping("/")
    public String root(){
        return "Hello World" ;
    }
}
