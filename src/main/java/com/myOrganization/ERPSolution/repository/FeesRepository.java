package com.myOrganization.ERPSolution.repository;

import com.myOrganization.ERPSolution.model.Fees;
import com.myOrganization.ERPSolution.model.FeesBackup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FeesRepository extends JpaRepository<Fees, Long> {
}