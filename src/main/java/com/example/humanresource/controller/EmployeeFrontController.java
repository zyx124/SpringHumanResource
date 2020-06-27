package com.example.humanresource.controller;

import com.example.humanresource.model.Employee;
import com.example.humanresource.model.SalaryReport;
import com.example.humanresource.service.EmployeeService;
import com.example.humanresource.service.SalaryReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.EmbeddedId;
import javax.validation.Valid;
import java.util.List;

@Controller
public class EmployeeFrontController {

    @Autowired
    private EmployeeService service;


    @GetMapping("/")
    public String showHomePage(Model model) {
        List<Employee> employees = service.getAllEmployees();
        model.addAttribute("employees", employees);
        return "index";
    }

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
            return "index";
        }
        service.deleteEmployeeById(id);
        List<Employee> employees = service.getAllEmployees();
        model.addAttribute("employees", employees);
        return "index";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") int id, Model model) {
        Employee employee = service.getEmployeeById(id);
        if (employee == null) {
            return "update-employee";
        }
        model.addAttribute("employee", employee);
        return "update-employee";

    }

    @PostMapping("/edit-employee/{id}")
    public String editEm(@PathVariable("id") int id, @Valid Employee employee, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "update-employee";
        }
        service.updateEmployee(id, employee);
        List<Employee> employees = service.getAllEmployees();
        model.addAttribute("employees", employees);
        return "redirect:/";
    }

}
