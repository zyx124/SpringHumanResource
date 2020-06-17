package com.example.humanresource.controller;

import com.example.humanresource.model.Department;
import com.example.humanresource.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    public DepartmentService service;

    @Autowired
    public void setDepartmentService(DepartmentService service) {
        this.service = service;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Department> getAllDepartments() {return service.getAllDepartments();}

    @GetMapping("/get/{id}")
    public Department getDepartmentById(@PathVariable int id) {
        return service.getDepartmentById(id);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public void createNewDept(@RequestBody Department dept) {
        service.createDepartment(dept);
    }

    @PutMapping("/update/{id}")
    public void updateDept(@PathVariable int id, @RequestBody Department temp) {
        service.updateDepartment(id, temp);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteDeptById(@PathVariable int id) {
        service.deleteDepartmentById(id);
    }

}
