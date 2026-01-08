package com.myOrganization.ERPSolution.controller.admin;

import com.myOrganization.ERPSolution.dto.attendanceDto.AttendanceReqDto;
import com.myOrganization.ERPSolution.dto.attendanceDto.AttendanceResDto;
import com.myOrganization.ERPSolution.dto.studentDto.StudentReqDto;
import com.myOrganization.ERPSolution.dto.studentDto.StudentResDto;
import com.myOrganization.ERPSolution.model.Student;
import com.myOrganization.ERPSolution.service.ServiceImpl.AttendanceService;
import com.myOrganization.ERPSolution.service.ServiceImpl.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;
    @Autowired
    AttendanceService attendanceService;

    @PostMapping("/register")
    public ResponseEntity<?> registerStudent(
            @Valid @RequestBody StudentReqDto studentReqDto) {

        StudentResDto res = studentService.register(studentReqDto);
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    StudentResDto getStudentById(@PathVariable Long id){
       return studentService.getById(id);
    }

    @PutMapping("/update/{id}")
    StudentResDto update(@RequestBody StudentReqDto student, @PathVariable Long id){
        return studentService.updateStudent(id,student);
    }


}
