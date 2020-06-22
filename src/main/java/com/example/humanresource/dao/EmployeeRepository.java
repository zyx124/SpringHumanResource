package com.example.humanresource.dao;

import com.example.humanresource.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    @Modifying
    @Query(value="insert into employee(empid, name, job, manager, salary, deptid) values (:id, :name, :job, :manager, :salary, :deptid)", nativeQuery=true)
    void create(@Param("id") int id, @Param("name") String name, @Param("job") String job, @Param("manager") int manager, @Param("salary") double salary, @Param("deptid") int deptid);

    @Query(value="Select empid from employee ORDER BY empid DESC", nativeQuery=true)
    List<Integer> getIdList();

    List<Employee> findAllByDeptId(int deptName);
}
