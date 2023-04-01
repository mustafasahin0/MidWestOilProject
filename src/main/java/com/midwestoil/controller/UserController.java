package com.midwestoil.controller;

import com.midwestoil.dto.RoleDTO;
import com.midwestoil.dto.UserDTO;
import com.midwestoil.service.RoleService;
import com.midwestoil.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/administration/user")
public class UserController {

    RoleService roleService;

    public UserController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping("/create")
    public String createUser(Model model) {

        model.addAttribute("user", new UserDTO());
        model.addAttribute("roles", roleService.findAll());

        return "administration/user/create";
    }
}
