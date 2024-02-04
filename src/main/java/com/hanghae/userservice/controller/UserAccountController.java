package com.hanghae.userservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class UserAccountController {

    private Environment env;

    @Autowired
    public UserAccountController(Environment env) {
        this.env = env;
    }

    @GetMapping("/health_check")
    public String status() {
        return "It`s Working in UserAccount Service";
    }

    @GetMapping("/welcome")
    public String welcome() {
        return env.getProperty("greeting.message");
    }
}
