package com.spring_security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @GetMapping("/users")
    public String manageUsers() {
        return "Trang quản lý người dùng (ADMIN)";
    }

    @GetMapping("/profile")
    public String profile() {
        return "Thông tin cá nhân";
    }
}
