package com.myOrganization.ERPSolution.controller.admin;

import com.myOrganization.ERPSolution.dto.marksDto.MarksReqDto;
import com.myOrganization.ERPSolution.dto.marksDto.MarksResDto;
import com.myOrganization.ERPSolution.model.Marks;
import com.myOrganization.ERPSolution.service.ServiceImpl.MarksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class MarksController {
    @Autowired
    MarksService marksService;

    @GetMapping("/findResult/{studentId}")
    ResponseEntity<?> printMarks(@PathVariable Long studentId){
        MarksResDto marksResDto = marksService.findResult(studentId);
        return new ResponseEntity<>(marksResDto, HttpStatusCode.valueOf(200));

    }

    @PostMapping("/updateMarks/{studentId}")
    ResponseEntity<?> updateMarks(@PathVariable Long studentId,@RequestBody MarksReqDto marksReqDto){
        MarksResDto marksResDto = marksService.updateMarks(studentId,marksReqDto);
        return new ResponseEntity<>(marksResDto, HttpStatusCode.valueOf(200));
    }

}
