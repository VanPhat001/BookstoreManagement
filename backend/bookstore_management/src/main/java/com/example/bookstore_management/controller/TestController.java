package com.example.bookstore_management.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class TestController {
    @GetMapping("/")
    public String getMethodName() {
        return "homepage";
    }
    
}
