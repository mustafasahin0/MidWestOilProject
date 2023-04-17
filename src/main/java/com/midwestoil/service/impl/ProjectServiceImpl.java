package com.midwestoil.service.impl;

import com.midwestoil.dto.ProjectDTO;
import com.midwestoil.dto.TaskDTO;
import com.midwestoil.dto.UserDTO;
import com.midwestoil.enums.Status;
import com.midwestoil.service.ProjectService;
import com.midwestoil.service.TaskService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectServiceImpl extends AbstractMapService<ProjectDTO, String> implements ProjectService {

    TaskService taskService;

    public ProjectServiceImpl(TaskService taskService) {
        this.taskService = taskService;
    }

    @Override
    public ProjectDTO save(ProjectDTO object) {
        return super.save(object.getProjectCode(), object);
    }

    @Override
    public List<ProjectDTO> findAll() {
        return super.findAll();
    }

    @Override
    public void update(ProjectDTO object) {
        super.update(object.getProjectCode(), object);
    }

    @Override
    public void deleteById(String id) {
        super.deleteById(id);
    }

    @Override
    public ProjectDTO findById(String id) {
        return super.findById(id);
    }

    @Override
    public void complete(ProjectDTO projectDTO) {
        projectDTO.setProjectStatus(Status.COMPLETE);
        super.save(projectDTO.getProjectCode(), projectDTO);
    }

    @Override
    public List<ProjectDTO> findAllNonCompletedProjects() {
        return findAll().stream().filter(projectDTO -> !projectDTO.getProjectStatus().equals(Status.COMPLETE)).collect(Collectors.toList());
    }

    @Override
    public List<ProjectDTO> getCountedListOfProjectDTO(UserDTO manager) {
        List<ProjectDTO> projectDTOList = findAll().stream()
                .filter(projectDTO -> projectDTO.getAssignedManager().equals(manager))
                .map(project -> {

                    List<TaskDTO> taskDTOListByManager = taskService.findTasksByManager(manager);

                    int completedTaskCount = taskDTOListByManager.stream().filter(each -> each.getProject().equals(project) && each.getTaskStatus().equals(Status.COMPLETE)).toList().size();
                    int uncompletedTaskCount = taskDTOListByManager.stream().filter(each -> each.getProject().equals(project) && !each.getTaskStatus().equals(Status.COMPLETE)).toList().size();

                    project.setCompleteTaskCounts(completedTaskCount);
                    project.setUnfinishedTaskCounts(uncompletedTaskCount);

                    return project;
                }).collect(Collectors.toList());
        return projectDTOList;
    }
}
