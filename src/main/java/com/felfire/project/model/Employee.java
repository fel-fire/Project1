package com.felfire.project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Employee {
    @Id
    private Integer id;
    private String name;
    private Integer departmentid;
}
