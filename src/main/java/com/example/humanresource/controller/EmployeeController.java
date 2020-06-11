package com.example.humanresource.controller;

import com.example.humanresource.dao.EmployeeRepository;
import com.example.humanresource.model.Employee;
import com.example.humanresource.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private EmployeeService service;

    // constructor-based injection
    @Autowired
    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Employee> getEmployees() {
        return service.getAllEmployees();
    }

    @RequestMapping(value = "/get/dept/{deptname}", method = RequestMethod.GET)
    public List<Employee> getEmployeeByDepartmentName(@PathVariable int deptname) {
        return service.getEmployeeByDepartment(deptname);
    }

    @GetMapping("/get/{id}")
    public Employee getEmployeeById(@PathVariable int id) {
        return service.getEmployeeById(id);
    }

    @PostMapping("/new")
    public void createEmployee(@RequestBody Employee temp) {
        service.newEmployee(temp);
    }

    @PutMapping("/update/{id}")
    public void updateEmployee(@PathVariable int id, @RequestBody Employee employee) {
        service.updateEmployee(id, employee);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEmployeeById(@PathVariable int id) {
        service.deleteEmployeeById(id);
    }

//    public EmployeeService getService() {
//        return service;
//    }
//
//    @Autowired
//    public void setService(EmployeeService service) {
//        this.service = service;
//    }
}
