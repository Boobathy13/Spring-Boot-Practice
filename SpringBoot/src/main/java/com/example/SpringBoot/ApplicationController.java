package com.example.SpringBoot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApplicationController {
    @GetMapping("/hello")
    String sayHelloWorld(){
        return "Hello World ..!";
    }
}
