package com.tedu.controller;

import com.tedu.service.AdminService;
import com.tedu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private UserService userService;

    @Autowired
    private AdminService adminService;

    @GetMapping("/login/{username}/{password}/{type}")
    public Object login(@PathVariable("username") String username, @PathVariable("password") String password, @PathVariable("type") String type) {
        Object obj = null;
        switch (type) {
            case "user":
                obj = userService.login(username, password);
                break;
            case "admin":
                obj = adminService.login(username, password);
                break;
        }
        return obj;
    }

}
