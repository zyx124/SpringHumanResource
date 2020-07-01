package com.example.humanresource.controller;

import com.example.humanresource.model.Employee;
import com.example.humanresource.model.SalaryReport;
import com.example.humanresource.service.EmployeeService;
import com.example.humanresource.service.SalaryReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;


@Controller
public class SalaryController {
    @Autowired
    private SalaryReportService salaryService;

    @Autowired
    private EmployeeService employeeService;

//    @GetMapping("/salary-report/{job-name}")
//    public List<SalaryReport> getSalaryReport(@PathVariable("job-name") String jobName, Model model) {
//        return salaryService.getSalaryReport(jobName);
//    }

    @PostMapping("/salary-report")
    public String getSalaryReport(@RequestParam String jobName, Model model) {
        List<SalaryReport> salaryReport = salaryService.getSalaryReport(jobName);
        model.addAttribute("salaryReport", salaryReport);
        return "salary-report";
    }

    @GetMapping("/charts")
    public String chart(Model model) {
        List<Employee> employees = employeeService.getAllEmployees();
        List<String> nameList = employees.stream().map(Employee::getName).collect(Collectors.toList());
        List<Double> salaryList = employees.stream().map(Employee::getSalary).collect(Collectors.toList());

        model.addAttribute("nameList", nameList);
        model.addAttribute("salaryList", salaryList);

        Integer northeastSales = 17089;
        Integer westSales = 10603;
        Integer midwestSales = 5223;
        Integer southSales = 10111;

        model.addAttribute("northeastSales", northeastSales);
        model.addAttribute("southSales", southSales);
        model.addAttribute("midwestSales", midwestSales);
        model.addAttribute("westSales", westSales);

//        List<String> categories = new ArrayList<String>();
//        categories.add("may");
//        categories.add("june");
//        categories.add("july");

        Set<String> categories = new HashSet<String>();
        categories.add("may");
        categories.add("june");
        categories.add("july");

        model.addAttribute("cate", categories);

        //now add sales by lure type
        List<Integer> inshoreSales = Arrays.asList(3455, 4112);
        List<Integer> nearshoreSales = Arrays.asList(3222, 3011, 3788);
        List<Integer> offshoreSales = Arrays.asList(7811, 7098, 6455);

        model.addAttribute("inshoreSales", inshoreSales);
        model.addAttribute("nearshoreSales", nearshoreSales);
        model.addAttribute("offshoreSales", offshoreSales);

        return "charts";
    }


}
