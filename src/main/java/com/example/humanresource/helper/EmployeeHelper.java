package com.example.humanresource.helper;

import com.example.humanresource.dao.EmployeeRepository;
import com.example.humanresource.dao.SalaryReportRepository;
import com.example.humanresource.model.Employee;
import com.example.humanresource.model.SalaryReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotNull;
import java.util.*;

@Component
public class EmployeeHelper {
    @Autowired
    private EmployeeRepository repo;

    @Autowired
    private SalaryReportRepository salaryRepo;

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
        List<Integer> idList = repo.getIdList();
        int id = Collections.max(idList) + 1;
        repo.create(id, temp.getName(), temp.getJob(), temp.getManager(), temp.getSalary(), temp.getDeptId());
    }

    public void updateEmployee(int id, Employee temp) {
        Optional<Employee> employeeOptional = repo.findById(id);
        if (!employeeOptional.isPresent()) {
            return;
        }
        Employee employee = employeeOptional.get();
        if (temp.getName() != null) {
            employee.setName(temp.getName());
        }
        if (temp.getJob() != null) {
            employee.setJob(temp.getJob());
        }
        if (temp.getDeptId() != null) {
            employee.setDeptId(temp.getDeptId());
        }
        if (temp.getHireDate() != null) {
            employee.setHireDate(temp.getHireDate());
        }
        if (temp.getManager() != null) {
            employee.setManager(temp.getManager());
        }

        repo.save(employee);

    }

    public void deleteEmployee(int id) {
        repo.deleteById(id);
    }

    public List<Employee> getEmployeeByDepartment(int deptName) {
        return repo.findAllByDeptId(deptName);
    }

    public List<SalaryReport> getSalaryReport(String jobName) {
        // repo.callProcedure(jobName);
        List<SalaryReport> result = salaryRepo.findAllSalaryReport();
        return result;
    }
}
