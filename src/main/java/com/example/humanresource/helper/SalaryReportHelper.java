package com.example.humanresource.helper;

import com.example.humanresource.dao.SalaryReportRepository;
import com.example.humanresource.model.SalaryReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SalaryReportHelper {
    @Autowired
    private SalaryReportRepository salaryRepo;

    public List<SalaryReport> getSalaryReport(String jobName) {
        salaryRepo.callProcedure(jobName);
        List<SalaryReport> result = salaryRepo.findAll();
        return result;
    }


}
