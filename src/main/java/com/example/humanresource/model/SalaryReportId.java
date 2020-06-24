package com.example.humanresource.model;



import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class SalaryReportId implements Serializable{
    private String job;
    private String department;

    public SalaryReportId() {
    }

    public SalaryReportId(String job, String department) {
        this.job = job;
        this.department = department;
    }

    public String getJob() {
        return job;
    }

    public String getDepartment() {
        return department;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
