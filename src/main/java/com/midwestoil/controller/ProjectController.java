package com.midwestoil.controller;

import com.midwestoil.dto.ProductDTO;
import com.midwestoil.dto.ProjectDTO;
import com.midwestoil.dto.UserDTO;
import com.midwestoil.service.ProjectService;
import com.midwestoil.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/administration/project")
public class ProjectController {

    ProjectService projectService;
    UserService userService;

    public ProjectController(ProjectService projectService, UserService userService) {
        this.projectService = projectService;
        this.userService = userService;
    }

    @GetMapping("/create")
    public String createProject(Model model) {
        model.addAttribute("project", new ProjectDTO());
        model.addAttribute("projects", projectService.findAll());
        model.addAttribute("managers", userService.findAll());

        return "/administration/project/create";
    }

    @PostMapping("/update")
    public String updateProject(ProjectDTO projectDTO) {
        projectService.save(projectDTO);
        return "redirect:/administration/project/create";
    }

    @GetMapping("/manager/project-status")
    public String getProjectsByManager(Model model) {
        UserDTO manager = userService.findById("john@cydeo.com");

        List<ProjectDTO> projects = projectService.getCountedListOfProjectDTO(manager);
        model.addAttribute("projects", projects);

        return "/manager/project-status";
    }
}
