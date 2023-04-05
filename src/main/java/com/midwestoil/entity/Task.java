package com.midwestoil.entity;

import com.midwestoil.dto.ProductDTO;
import com.midwestoil.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@Data
public class Task {

    private Long id;
    private ProductDTO project;
    private UserDTO assignedEmployee;
    private String taskSubject;
    private String taskDetail;
    private LocalDate assignedDate;

    public Task(Long id, ProductDTO project, UserDTO assignedEmployee, String taskSubject, String taskDetail, LocalDate assignedDate) {
        this.id = id;
        this.project = project;
        this.assignedEmployee = assignedEmployee;
        this.taskSubject = taskSubject;
        this.taskDetail = taskDetail;
        this.assignedDate = assignedDate;
    }
}
