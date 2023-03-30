package com.midwestoil.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/administration/user")
public class UserController {

    @GetMapping("/create")
    public String createUser() {
        return "administration/user/create";
    }
}
