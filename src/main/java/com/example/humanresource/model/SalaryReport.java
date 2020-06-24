package com.example.humanresource.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "salary_report")
@IdClass(SalaryReportId.class)
public class SalaryReport {
    @Id
    private String job;

    @Id
    private String department;

    private double salmin;

    private double salmax;

    private double salavg;

    private double saltotal;

    @Column(name = "empcount")
    private int employeeCount;

    @Column(name = "updatetime")
    private Date updateTime;

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getSalmin() {
        return salmin;
    }

    public void setSalmin(double salmin) {
        this.salmin = salmin;
    }

    public double getSalmax() {
        return salmax;
    }

    public void setSalmax(double salmax) {
        this.salmax = salmax;
    }

    public double getSalavg() {
        return salavg;
    }

    public void setSalavg(double salavg) {
        this.salavg = salavg;
    }

    public double getSaltotal() {
        return saltotal;
    }

    public void setSaltotal(double saltotal) {
        this.saltotal = saltotal;
    }

    public int getEmployeeCount() {
        return employeeCount;
    }

    public void setEmployeeCount(int employeeCount) {
        this.employeeCount = employeeCount;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
