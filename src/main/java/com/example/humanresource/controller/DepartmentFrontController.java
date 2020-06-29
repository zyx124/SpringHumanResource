package com.example.humanresource.controller;

import com.example.humanresource.model.Department;
import com.example.humanresource.model.Employee;
import com.example.humanresource.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.naming.Binding;
import javax.validation.Valid;
import java.util.List;

@Controller
public class DepartmentFrontController {
    @Autowired
    private DepartmentService service;

    @GetMapping("/show-department")
    public String showDepartment(Model model) {
        List<Department> departments = service.getAllDepartments();
        if (departments.isEmpty()) {
            return "index";
        }
        model.addAttribute("departments", departments);
        return "show-department";
    }

    @GetMapping("/edit-department/{id}")
    public String showUpdateForm(@PathVariable("id") int id, Model model) {
        Department department = service.getDepartmentById(id);
        if (department == null) {
            return "update-employee";
        }
        model.addAttribute("department", department);
        return "update-department";
    }

    @PostMapping("/edit-department/{id}")
    public String updateDep(@PathVariable("id") int id, @Valid Department department, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "update-department";
        }
        service.updateDepartment(id, department);
        List<Department> departments = service.getAllDepartments();
        model.addAttribute("departments", departments);
        return "redirect:show-department";
    }

    @GetMapping("/add-department")
    public String showEditForm(Model model) {
        model.addAttribute("department", new Department());
        return "add-department";
    }


    @PostMapping("/add-department")
    public String addEm(@Valid Department department, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "add-department";
        }
        service.createDepartment(department);
        return "redirect:show-department";
    }

    @GetMapping("/delete-department/{id}")
    public String deleteEm(@PathVariable("id") int id, Model model) {
        Department department = service.getDepartmentById(id);
        if (department == null) {
            return "index";
        }
        service.deleteDepartmentById(id);
        List<Department> departments = service.getAllDepartments();
        model.addAttribute("departments", departments);
        return "show-department";
    }


}
