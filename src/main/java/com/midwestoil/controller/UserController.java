package com.midwestoil.controller;

import com.midwestoil.dto.RoleDTO;
import com.midwestoil.dto.UserDTO;
import com.midwestoil.service.RoleService;
import com.midwestoil.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    public String insertUser(UserDTO userDTO) {
        userService.save(userDTO);
        return "redirect:/administration/user/create";
    }

    @GetMapping("/update/{username}")
    public String editUser(@PathVariable("username") String username, Model model) {

        model.addAttribute("user", userService.findById(username));
        model.addAttribute("roles", roleService.findAll());
        model.addAttribute("users", userService.findAll());
        return "administration/user/update";
    }

    @PostMapping("/update")
    public String updateUser(UserDTO userDTO) {
        userService.update(userDTO);
        return "redirect:/administration/user/create";
    }
}
