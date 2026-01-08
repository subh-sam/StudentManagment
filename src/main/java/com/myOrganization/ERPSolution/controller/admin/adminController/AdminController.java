package com.myOrganization.ERPSolution.controller.admin.adminController;

import com.myOrganization.ERPSolution.dto.adminDto.AdminRequest;
import com.myOrganization.ERPSolution.dto.adminDto.AdminResponce;
import com.myOrganization.ERPSolution.service.ServiceImpl.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    AdminService adminService;

    @PostMapping
    ResponseEntity<AdminResponce> registerAdmin(@RequestBody AdminRequest adminRequest){
        return ResponseEntity.ok(adminService.adminRegister());
    }
}
