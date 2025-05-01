package com.felfire.project.controller;

import com.felfire.project.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public String getStatic() {
        return "static";
    }

    @GetMapping("/list")
    public String getEmployeeList(Model model) {
        model.addAttribute("employees", employeeService.getEmployees());
        return "employeesList";
    }
}
