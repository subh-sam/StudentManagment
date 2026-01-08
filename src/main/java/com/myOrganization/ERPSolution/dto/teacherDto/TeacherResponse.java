package com.myOrganization.ERPSolution.dto.teacherDto;

import lombok.Data;

@Data
public class TeacherResponse {
    Long id;
    private String name;
    private String phone;
    private String password;
}
