package com.example.humanresource.controller;

import com.example.humanresource.model.Employee;
import com.example.humanresource.model.SalaryReport;
import com.example.humanresource.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class FrontController {

    @Autowired
    private EmployeeService service;

    @GetMapping("/")
    public String showHomePage(Model model) {
        List<Employee> employees = service.getAllEmployees();
        model.addAttribute("employees", employees);
        return "index";
    }

//    @PostMapping("/modifyemployee/{id}")
//    public String updateEmployeeFront(@PathVariable int id, @RequestBody Employee employee, Model model) {
//        Employee getEmployee = service.getEmployeeById(id);
//        if (getEmployee == null) {
//            System.out.println("Invalid user Id: " + id);
//
//        }
//        model.addAttribute("employee", employee);
//        return "updateEmployee";
//    }

    @GetMapping("/add")
    public String showEditForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "add-employee";
    }

    @PostMapping("/add")
    public String addEm(@Valid Employee employee, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "add-employee";
        }
        service.newEmployee(employee);
        return "redirect:/";
    }

    @GetMapping("/delete-employee/{id}")
    public String deleteEm(@PathVariable("id") int id, Model model) {
        Employee employee = service.getEmployeeById(id);
        if (employee == null) {
            return "<p> The id is invalid!</p>";
        }
        service.deleteEmployeeById(id);
        List<Employee> employees = service.getAllEmployees();
        model.addAttribute("employees", employees);
        return "index";
    }

    @GetMapping("/salary-report/{job-name}")
    public List<SalaryReport> getSalaryReport(@PathVariable("job-name") String jobName, Model model) {
        return service.getSalaryReport(jobName);
    }
}
