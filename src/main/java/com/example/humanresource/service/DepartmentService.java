package com.example.humanresource.service;

import com.example.humanresource.helper.DepartmentHelper;
import com.example.humanresource.model.Department;
import com.example.humanresource.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;


@Service
public class DepartmentService {
    @Autowired
    private DepartmentHelper helper;

    public List<Department> getAllDepartments() {
        return helper.getAllDepartments();
    }

    public Department getDepartmentById(int id) {
        return helper.getDepartmentById(id);
    }

    public void createDepartment(Department temp) {
        helper.createDepartment(temp);
    }

    public void updateDepartment(int id, Department temp) {
        helper.updateDepartment(id, temp);
    }

    public void deleteDepartmentById(int id) {
        helper.deleteDepartment(id);
    }
}
