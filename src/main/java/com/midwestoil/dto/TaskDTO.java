package com.midwestoil.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TaskDTO {

    private Long id;
    private ProductDTO project;
    private UserDTO assignedEmployee;
    private String taskSubject;
    private String taskDetail;
    private LocalDate assignedDate;
}
