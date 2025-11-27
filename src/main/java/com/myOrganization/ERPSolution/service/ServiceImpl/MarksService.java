package com.myOrganization.ERPSolution.service.ServiceImpl;

import com.myOrganization.ERPSolution.Exception.StudentNotFoundException;
import com.myOrganization.ERPSolution.dto.marksDto.MarksReqDto;
import com.myOrganization.ERPSolution.dto.marksDto.MarksResDto;
import com.myOrganization.ERPSolution.model.Fees;
import com.myOrganization.ERPSolution.model.Marks;
import com.myOrganization.ERPSolution.model.Student;
import com.myOrganization.ERPSolution.repository.MarksRepository;
import com.myOrganization.ERPSolution.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;

import java.security.PublicKey;

@Service
public class MarksService {
    @Autowired
    MarksRepository marksRepository;
    @Autowired
    StudentRepo studentRepo;

    public MarksResDto findResult(Long studentId){
        Student student = studentRepo.findById(studentId).orElseThrow(()->new StudentNotFoundException("Student Id Does Not Exist"));
        MarksResDto marksResDto = new MarksResDto();
        marksResDto.setStudentId(student.getStudentId());
        marksResDto.setStudentName(student.getName());
        marksResDto.setPhysics(student.getMarks().getPhysics());
        marksResDto.setMathematics(student.getMarks().getMathematics());
        marksResDto.setChemistry(student.getMarks().getChemistry());
        marksResDto.setBiology(student.getMarks().getBiology());
        return marksResDto;
    }

    public MarksResDto updateMarks(Long studentId, MarksReqDto marksReqDto){
        Student student = studentRepo.findById(studentId).orElseThrow(()->new StudentNotFoundException("Student Id Does Not Exist"));

        Long marksId = student.getMarks().getMarksId();

        Marks marks = marksRepository.getReferenceById(marksId);

        marks.setPhysics(marksReqDto.getPhysics());
        marks.setMathematics(marksReqDto.getMathematics());
        marks.setChemistry(marksReqDto.getChemistry());
        marks.setBiology(marksReqDto.getBiology());
        marks = marksRepository.save(marks);

        MarksResDto marksResDto = new MarksResDto();
        marksResDto.setStudentId(marks.getStudent().getStudentId());
        marksResDto.setStudentName(student.getName());
        marksResDto.setPhysics(marks.getPhysics());
        marksResDto.setMathematics(marks.getMathematics());
        marksResDto.setChemistry(marks.getChemistry());
        marksResDto.setBiology(marks.getBiology());
        return marksResDto;
    }

}
