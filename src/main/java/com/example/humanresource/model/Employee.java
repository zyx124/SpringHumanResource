package com.example.humanresource.model;


import javax.persistence.*;
import java.util.*;


@Entity
@Table
public class Employee {
    @Id
    @Column(name = "empid")
    private int id;

    private String name;
    private String job;
    private Integer manager;

    @Column(name = "hiredate")
    private Date hireDate;

    private Double salary;

    @Column(name = "deptid")
    private int deptId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Integer getManager() {
        return manager;
    }

    public void setManager(Integer manager) {
        this.manager = manager;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public Employee() {
    }

}
