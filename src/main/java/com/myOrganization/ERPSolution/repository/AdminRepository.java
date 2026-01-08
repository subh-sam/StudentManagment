package com.myOrganization.ERPSolution.repository;

import com.myOrganization.ERPSolution.model.admin.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
}