package com.example.humanresource.helper;

import com.example.humanresource.dao.DepartmentRepository;
import com.example.humanresource.model.Department;
import com.example.humanresource.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Component
public class DepartmentHelper {
    @Autowired
    private DepartmentRepository repo;

    public Department getDepartmentById(int id) {
        Optional<Department> departmentOptional = repo.findById(id);
        return departmentOptional.orElse(null);
    }

    public List<Department> getAllDepartments() {
        return repo.findAll();
    }

    @Transactional
    public void createDepartment(Department temp) {
        temp.setDeptId(95);
        repo.create(temp.getDeptId(), temp.getName());
    }

    public void updateDepartment(int id, Department dept) {
        Optional<Department> departmentOptional = repo.findById(id);
        if (!departmentOptional.isPresent()) {
            return;
        }
        Department department = departmentOptional.get();
        department.setName(dept.getName());
        repo.save(department);
    }

    public void deleteDepartment(int id) {repo.deleteById(id);}


}

