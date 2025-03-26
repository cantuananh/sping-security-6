package com.spring_security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping("/home")
    public String home() {
        return "Trang chủ";
    }

    @GetMapping("/contact")
    public String contact() {
        return "Trang liên hệ";
    }
}
