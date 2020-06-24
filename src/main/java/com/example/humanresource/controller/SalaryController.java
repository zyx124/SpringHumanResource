package com.example.humanresource.controller;

import com.example.humanresource.model.SalaryReport;
import com.example.humanresource.service.SalaryReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class SalaryController {
    @Autowired
    private SalaryReportService salaryService;

//    @GetMapping("/salary-report/{job-name}")
//    public List<SalaryReport> getSalaryReport(@PathVariable("job-name") String jobName, Model model) {
//        return salaryService.getSalaryReport(jobName);
//    }

    @GetMapping("/salary-report")
    public @ResponseBody  List<SalaryReport> getSalaryReport() {
        return salaryService.getSalaryReport();
    }
}
