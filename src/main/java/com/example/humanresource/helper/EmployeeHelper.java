package com.example.humanresource.helper;

import com.example.humanresource.dao.EmployeeRepository;
import com.example.humanresource.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Component
public class EmployeeHelper {
    @Autowired
    private EmployeeRepository repo;

    public Employee getEmployeeById(int id) {
        Optional<Employee> employeeOptional = repo.findById(id);
        if (employeeOptional.isPresent()) {
            return employeeOptional.get();
        } else {
            return null;
        }
    }

    public List<Employee> getAllEmployees() {
        return repo.findAll();
    }

    @Transactional
    public void createEmployee(Employee temp) {
        temp.setId(9999);
        repo.create(temp.getId(), temp.getName());
    }

    public void updateEmployee(int id, Employee temp) {
        Optional<Employee> employeeOptional = repo.findById(id);
        if (!employeeOptional.isPresent()) {
            return;
        }
        Employee employee = employeeOptional.get();
        employee.setName(temp.getName());
        repo.save(employee);
    }

    public void deleteEmployee(int id) {
        repo.deleteById(id);
    }

    public List<Employee> getEmployeeByDepartment(int deptName) {
        return repo.findAllByDeptId(deptName);
    }
}
