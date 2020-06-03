package com.example.humanresource.model;

import javax.persistence.*;
import java.util.*;

@Entity
@Table
public class Department {
    @Id
    @Column(name = "deptid")
    private int deptId;

    private String name;

    private String loc;

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public Department() {
    }
}
