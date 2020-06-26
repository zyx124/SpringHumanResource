package com.example.humanresource.controller;

import com.example.humanresource.model.Employee;
import com.example.humanresource.model.SalaryReport;
import com.example.humanresource.service.SalaryReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class SalaryController {
    @Autowired
    private SalaryReportService salaryService;

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


}
