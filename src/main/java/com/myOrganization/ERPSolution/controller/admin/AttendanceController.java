package com.myOrganization.ERPSolution.controller.admin;

import com.myOrganization.ERPSolution.dto.attendanceDto.AttendanceReqDto;
import com.myOrganization.ERPSolution.dto.attendanceDto.AttendanceResDto;
import com.myOrganization.ERPSolution.repository.AttendanceRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.myOrganization.ERPSolution.service.ServiceImpl.AttendanceService;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/student")
public class AttendanceController {
    @Autowired
    AttendanceService attendanceService;

    @GetMapping("/findAttendance/{studentId}")
    List<AttendanceResDto> getAttendanceById(@PathVariable Long studentId){
        return attendanceService.getAttendanceById(studentId);
    }

    @GetMapping("/findAttendance")
    ResponseEntity<?> getAttendanceByDateAndClass(@RequestBody AttendanceReqDto attendanceReqDto){
        List<AttendanceResDto> attendanceResDtoList = attendanceService.getAttendanceByDateAndClass(attendanceReqDto);
        return new ResponseEntity<>(attendanceResDtoList,HttpStatusCode.valueOf(200));
    }

    @GetMapping("/findByStudentClass/{studentClass}")
    ResponseEntity<?> getAttendanceByClass(@PathVariable Integer studentClass){
        List<AttendanceResDto> attendanceResDtoList = attendanceService.getAttendanceByClass(studentClass);
        return new ResponseEntity<>(attendanceResDtoList,HttpStatusCode.valueOf(200));
    }

    @PostMapping("/getAttendance")
    ResponseEntity<?> takeAttendance(@RequestBody List<AttendanceReqDto> attendanceReqDtos){
        List<AttendanceResDto> attendanceResDtoList = attendanceService.takeAttendance(attendanceReqDtos);
        return new ResponseEntity<>(attendanceResDtoList,HttpStatusCode.valueOf(200));
    }

}
