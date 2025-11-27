package com.myOrganization.ERPSolution.repository;


import com.myOrganization.ERPSolution.model.FeesBackup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FeesBackUpRepo extends JpaRepository<FeesBackup, Long> {
    @Query(value = "Select * from Fees_Backup where student_Id =:studentId" , nativeQuery = true)
    List<FeesBackup> findAllFeesByStudentId(@Param("studentId") Long studentId);
}
