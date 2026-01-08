package com.myOrganization.ERPSolution.controller.admin.teacherControler;

import com.myOrganization.ERPSolution.dto.teacherDto.FindTeacherReq;
import com.myOrganization.ERPSolution.dto.teacherDto.TeacherRequest;
import com.myOrganization.ERPSolution.dto.teacherDto.TeacherResponse;
import com.myOrganization.ERPSolution.service.ServiceImpl.teacherService.TeacherService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
//@RequiredArgsConstructor
@RequestMapping("/teacher")
public class TeacherControler {
@Autowired
    TeacherService teacherService;
    @PostMapping("/registration")
    ResponseEntity<TeacherResponse> registration(@Valid @RequestBody TeacherRequest teacherRequest){
        return ResponseEntity.ok(teacherService.registration(teacherRequest));
    }

    @GetMapping("/get/teacher")
    ResponseEntity<TeacherResponse> getTeacher(@Valid @RequestBody FindTeacherReq findTeacherReq){
        return ResponseEntity.ok(teacherService.getUser(findTeacherReq.getName(), findTeacherReq.getId()));
    }

    @DeleteMapping("/remove/teacher/{id}")
    ResponseEntity<String> removeTeacher(@PathVariable Long id){
        return ResponseEntity.ok(teacherService.removeTeacher(id));
    }

}
