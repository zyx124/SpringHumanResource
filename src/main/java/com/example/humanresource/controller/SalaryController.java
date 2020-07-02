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

import static java.util.stream.Collectors.groupingBy;


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
        List<Double> minSalary = salaryReport.stream().map(SalaryReport::getSalmin).collect(Collectors.toList());
        List<Double> maxSalary = salaryReport.stream().map(SalaryReport::getSalmax).collect(Collectors.toList());
        List<Double> avgSalary = salaryReport.stream().map(SalaryReport::getSalavg).collect(Collectors.toList());
        List<Double> totalSalary = salaryReport.stream().map(SalaryReport::getSaltotal).collect(Collectors.toList());
        List<Integer> empNumber = salaryReport.stream().map(SalaryReport::getEmployeeCount).collect(Collectors.toList());
        List<String> deptName = salaryReport.stream().map(SalaryReport::getDepartment).collect(Collectors.toList());
        model.addAttribute("minSalary", minSalary);
        model.addAttribute("maxSalary", maxSalary);
        model.addAttribute("totalSalary", totalSalary);
        model.addAttribute("avgSalary", avgSalary);
        model.addAttribute("empNumber", empNumber);
        model.addAttribute("deptName", deptName);
        model.addAttribute("jobName", "Salary Report of " + jobName.toUpperCase());

        return "salary-report";
    }

    @GetMapping("/salary-charts")
    public String chart(Model model) {
        List<Employee> employees = employeeService.getAllEmployees();
        List<String> nameList = employees.stream().map(Employee::getName).collect(Collectors.toList());
        List<Double> salaryList = employees.stream().map(Employee::getSalary).collect(Collectors.toList());
        Map<String, Double> salaryMap = employees.stream().collect(Collectors
                                                        .toMap(Employee::getName, Employee::getSalary));

        model.addAttribute("salaryMap", salaryMap);

        ///

        Map<Integer, List<Employee>> groupByDept = employees.stream()
                                                        .collect(groupingBy(Employee::getDeptId));


        Set<Integer> deptIdList = groupByDept.keySet();
        Map<Integer, List<Double>> salaryByDeptList = new HashMap<Integer, List<Double>>();
        for (Integer key: groupByDept.keySet()) {
            salaryByDeptList.put(key, groupByDept.get(key).stream()
                                                    .map(Employee::getSalary)
                                                    .collect(Collectors.toList()));
        }
        System.out.println(salaryByDeptList.keySet());
        System.out.println(salaryByDeptList.values());




        Integer northeastSales = 17089;
        Integer westSales = 10603;
        Integer midwestSales = 5223;
        Integer southSales = 10111;

        model.addAttribute("northeastSales", northeastSales);
        model.addAttribute("southSales", southSales);
        model.addAttribute("midwestSales", midwestSales);
        model.addAttribute("westSales", westSales);


        // model.addAttribute("deptIdList", deptIdList);

        //now add sales by lure type
        List<Integer> inshoreSales = Arrays.asList(3455, 4112);
        List<Integer> nearshoreSales = Arrays.asList(3222, 3011, 3788);
        List<Integer> offshoreSales = Arrays.asList(7811, 7098, 6455);

        model.addAttribute("salaryByDeptList", salaryByDeptList);


        return "salary-charts";
    }



}
