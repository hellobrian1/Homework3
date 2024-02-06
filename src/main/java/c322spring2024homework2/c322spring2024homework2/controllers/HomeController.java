package c322spring2024homework2.c322spring2024homework2.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String greetings(){
        return "Welcome to homework2!";
    }
}