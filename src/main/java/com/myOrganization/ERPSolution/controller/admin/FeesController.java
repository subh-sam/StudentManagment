package com.myOrganization.ERPSolution.controller.admin;

import com.myOrganization.ERPSolution.dto.feesDto.FeesResDto;
import com.myOrganization.ERPSolution.dto.feesDto.FeesUpdateDto;
import com.myOrganization.ERPSolution.service.ServiceImpl.FeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class FeesController {
    @Autowired
    FeesService feesService;

    @GetMapping("/findFees/{studentId}")
    ResponseEntity<?> findFees(@PathVariable Long studentId){
        List<FeesResDto> feesResDto = feesService.findFees(studentId);
        return new ResponseEntity<>(feesResDto, HttpStatusCode.valueOf(200));
    }

    @PutMapping("/updatesFees/{studentId}")
    ResponseEntity<?> updateFees(@PathVariable Long studentId, @RequestBody FeesUpdateDto feesUpdateDto){
        FeesResDto feesResDto = feesService.updateFees(studentId,feesUpdateDto);
        return new ResponseEntity<>(feesResDto, HttpStatusCode.valueOf(200));
    }

}
