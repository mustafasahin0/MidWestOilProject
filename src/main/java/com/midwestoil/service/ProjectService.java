package com.midwestoil.service;

import com.midwestoil.dto.ProjectDTO;
import com.midwestoil.dto.UserDTO;

import java.util.List;

public interface ProjectService extends CrudService<ProjectDTO, String>{

    void complete(ProjectDTO projectDTO);
    List<ProjectDTO> findAllNonCompletedProjects();
    List<ProjectDTO> getCountedListOfProjectDTO(UserDTO manager);
}
