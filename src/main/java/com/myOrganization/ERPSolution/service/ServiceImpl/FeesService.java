package com.myOrganization.ERPSolution.service.ServiceImpl;

import com.myOrganization.ERPSolution.Exception.StudentNotFoundException;
import com.myOrganization.ERPSolution.dto.feesDto.FeesResDto;
import com.myOrganization.ERPSolution.dto.feesDto.FeesUpdateDto;
import com.myOrganization.ERPSolution.dto.feesDto.FessBackUp;
import com.myOrganization.ERPSolution.model.Fees;
import com.myOrganization.ERPSolution.model.FeesBackup;
import com.myOrganization.ERPSolution.model.Student;

import com.myOrganization.ERPSolution.repository.FeesBackUpRepo;
import com.myOrganization.ERPSolution.repository.FeesRepository;
import com.myOrganization.ERPSolution.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class FeesService {
    @Autowired
    FeesRepository feesRepository;
    @Autowired
    private StudentRepo studentRepo;
    @Autowired
    private FeesBackUpRepo feesBackUpRepo;

    public List<FeesResDto> findFees(Long studentId) {
//        Student student = studentRepo.findById(studentId).orElseThrow(()->new StudentNotFoundException("FeesID is Incorrect"));
//        Long feesId = student.getFees().getFeesId();
//        Fees fees = feesRepository.getReferenceById(feesId);

        List<FeesBackup> fees = feesBackUpRepo.findAllFeesByStudentId(studentId);

        if (fees.isEmpty()){
            throw new StudentNotFoundException("Student Not Found");
        }

        List<FeesResDto> feesUpdateDto = new ArrayList<>();
        for (FeesBackup fee : fees) {
            FeesResDto feesResDto = new FeesResDto();
            feesResDto.setStudentId(fee.getStudentId());
            feesResDto.setStudentName(fee.getStudentName());
            feesResDto.setLastPaymentDate(fee.getLastPaymentDate());
            feesResDto.setPaidFees(fee.getPaidFees());
            feesResDto.setTotalFees(fee.getTotalFees());

            feesUpdateDto.add(feesResDto);
        }
        return feesUpdateDto;
    }

    public FeesResDto updateFees(Long studentId , FeesUpdateDto feesUpdateDto){
        Student student = studentRepo.findById(studentId).orElseThrow(()->new StudentNotFoundException("Student Id is not Match"));
        Long feesId = student.getFees().getFeesId();
        Fees fees = feesRepository.getReferenceById(feesId);
        Integer oldFee = fees.getPaidFees()==null ? 0 : fees.getPaidFees();
        fees.setPaidFees(feesUpdateDto.getPaidFees()+oldFee);
        fees.setLastPaymentDate(feesUpdateDto.getLastPaymentDate());
        fees = feesRepository.save(fees);

        FeesBackup feesBackUp = new FeesBackup();
        feesBackUp.setStudentName(fees.getName());
        feesBackUp.setTotalFees(fees.getTotalFees());
        feesBackUp.setLastPaymentDate(feesUpdateDto.getLastPaymentDate());
        feesBackUp.setPaidFees((fees.getPaidFees()+feesUpdateDto.getPaidFees()));
        feesBackUp.setStudentId(fees.getStudent().getStudentId());
        feesBackUpRepo.save(feesBackUp);

        return converFeesToFeesResDto(fees);
    }

    private FeesResDto converFeesToFeesResDto(Fees fees) {
        FeesResDto feesResDto = new FeesResDto();
        feesResDto.setStudentId(fees.getStudent().getStudentId());
        feesResDto.setStudentName(fees.getName());
        feesResDto.setLastPaymentDate(fees.getLastPaymentDate());
        feesResDto.setPaidFees(fees.getPaidFees());
        feesResDto.setTotalFees(fees.getTotalFees());
        return feesResDto;
    }

}
