package com.midwestoil.controller;

import com.midwestoil.dto.RoleDTO;
import com.midwestoil.dto.UserDTO;
import com.midwestoil.service.RoleService;
import com.midwestoil.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/administration/user")
public class UserController {

    RoleService roleService;
    UserService userService;

    public UserController(RoleService roleService, UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    @GetMapping("/create")
    public String createUser(Model model) {

        model.addAttribute("user", new UserDTO());
        model.addAttribute("roles", roleService.findAll());
        model.addAttribute("users", userService.findAll());

        return "administration/user/create";
    }

    @PostMapping("/create")
    public String insertUser(UserDTO userDTO, Model model) {
        userService.save(userDTO);
        return "redirect:/administration/user/create";
    }
}
