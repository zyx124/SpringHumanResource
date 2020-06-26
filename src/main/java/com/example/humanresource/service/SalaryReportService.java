package com.example.humanresource.service;

import com.example.humanresource.helper.SalaryReportHelper;
import com.example.humanresource.model.SalaryReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalaryReportService {
    @Autowired
    private SalaryReportHelper helper;

    public List<SalaryReport> getSalaryReport(String job) {
        return helper.getSalaryReport(job);
    }

}
