package com.example.humanresource.service;

import com.example.humanresource.helper.EmployeeHelper;
import com.example.humanresource.model.Employee;
import com.example.humanresource.model.SalaryReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeHelper helper;

    public Employee getEmployeeById(int id) {
        return helper.getEmployeeById(id);
    }

    public List<Employee> getAllEmployees() {
        return helper.getAllEmployees();
    }

    public void newEmployee(Employee temp) {
        helper.createEmployee(temp);
    }

    public void updateEmployee(int id, Employee temp) {
        helper.updateEmployee(id, temp);
    }

    public void deleteEmployeeById(int id) {
        helper.deleteEmployee(id);
    }

    public List<Employee> getEmployeeByDepartment(int deptName) {
        return helper.getEmployeeByDepartment(deptName);
    }

    public List<SalaryReport> getSalaryReport(String jobName) {
        return helper.getSalaryReport(jobName);
    }

}
