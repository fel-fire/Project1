package com.felfire.project.service;

import com.felfire.project.model.Employee;
import com.felfire.project.repository.EmployeeRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    private EmployeeRepo employeeRepo;

    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public List<Employee> getEmployees() {
        List<Employee> result = new ArrayList<>();
        employeeRepo.findAll().forEach(result::add);
        return result;
    }
}
