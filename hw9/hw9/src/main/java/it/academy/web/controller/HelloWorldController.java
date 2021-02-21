package it.academy.web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.logging.Logger;

@Controller
public class HelloWorldController {

    @GetMapping("/hello.html")
    public String hello(Model model){
        String message = "Hello World with Tile framework in homework 9";
        Logger logger = Logger.getLogger(HelloWorldController.class.getName());
        model.addAttribute("message", message);
        return "hello";
    }

}
