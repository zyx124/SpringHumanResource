package com.example.humanresource.dao;

import com.example.humanresource.model.SalaryReport;
import com.example.humanresource.model.SalaryReportId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalaryReportRepository extends JpaRepository<SalaryReport, SalaryReportId> {

//    @Query(value="call spGenerateReport(:job_in)", nativeQuery=true)
//    void callProcedure(@Param("job_in") String jobName);
//

}
