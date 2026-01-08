package com.myOrganization.ERPSolution.dto.teacherDto;

import lombok.Data;

@Data
public class FindTeacherReq {
    // only use for Teacher find
    private Long id;
    private String name;
}
