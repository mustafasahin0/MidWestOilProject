package com.midwestoil.service;

import com.midwestoil.dto.ProductDTO;
import com.midwestoil.dto.TaskDTO;
import com.midwestoil.dto.TaxDTO;
import com.midwestoil.dto.UserDTO;
import com.midwestoil.enums.Status;

import java.util.List;

public interface TaskService extends CrudService<TaskDTO, Long> {

    List<TaskDTO> findTasksByManager(UserDTO manager);

    List<TaskDTO> findAllTasksByStatus(Status status);

    List<TaskDTO> findAllTasksByStatusIsNot(Status status);

    void updateStatus(TaskDTO task);

}
