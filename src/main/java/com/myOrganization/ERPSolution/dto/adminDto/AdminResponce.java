package com.myOrganization.ERPSolution.dto.adminDto;

import lombok.Data;

@Data
public class AdminResponce {
    private Long id;
    private String name;
    private Long phone;
    private String email;
    private String password;
}
