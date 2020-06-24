package com.example.humanresource.dao;

import com.example.humanresource.model.SalaryReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SalaryReportRepository extends JpaRepository {

    @Query(value="call spGenerateReport(:job_in)", nativeQuery=true)
    void callProcedure(@Param("job_in") String jobName);

    List<SalaryReport> findAllSalaryReport();

}
