package com.myOrganization.ERPSolution.service.ServiceImpl;

import com.myOrganization.ERPSolution.Exception.StudentNotFoundException;
import com.myOrganization.ERPSolution.dto.feesDto.FessBackUp;
import com.myOrganization.ERPSolution.dto.studentDto.StudentReqDto;
import com.myOrganization.ERPSolution.dto.studentDto.StudentResDto;
import com.myOrganization.ERPSolution.model.*;
import com.myOrganization.ERPSolution.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class StudentService {

    @Autowired
    StudentRepo studentRepo;
    @Autowired
    AttendanceRepository attendanceRepository;
    @Autowired
    FeesRepository feesRepository;
    @Autowired
    MarksRepository marksRepository;
    @Autowired
    private FeesBackUpRepo feesBackUpRepo;

    public StudentResDto register(StudentReqDto studentReqDto){
        Student student = new Student();

        student.setName(studentReqDto.getName());
        student.setStudentClass(studentReqDto.getStudentClass());
        student.setEmail(studentReqDto.getEmail());
        student.setFatherName(studentReqDto.getFatherName());
        student.setMotherName(studentReqDto.getMotherName());
        student.setAddress(studentReqDto.getAddress());
        student.setNumber(studentReqDto.getNumber());
        student.setRollNumber(studentReqDto.getRollNumber());
        student.setAge(studentReqDto.getAge());
        student = studentRepo.save(student);


        Fees fees = new Fees();
        fees.setName(student.getName());
        fees.setStudent(student);
        fees.setTotalFees(studentReqDto.getTotalFees());
        fees= feesRepository.save(fees);

        FeesBackup fessBackup = new FeesBackup();
        fessBackup.setStudentId(student.getStudentId());
        fessBackup.setStudentName(student.getName());
        fessBackup.setTotalFees(studentReqDto.getTotalFees());
        fessBackup.setStudentId(student.getStudentId());
        feesBackUpRepo.save(fessBackup);


Marks marks = new Marks();
marks.setStudentName(student.getName());
marks.setStudent(student);
marksRepository.save(marks);

Attendance attendance = new Attendance();
attendance.setStudentName(student.getName());
attendance.setStudentClass(student.getStudentClass());
attendance.setStudent(student);
attendance.setRollNumber(student.getRollNumber());
attendanceRepository.save(attendance);

        StudentResDto studentResDto1 = new StudentResDto();

        studentResDto1.setName(student.getName());
        studentResDto1.setStudentClass(student.getStudentClass());
        studentResDto1.setEmail(student.getEmail());
        studentResDto1.setAddress(student.getAddress());
        studentResDto1.setFatherName(student.getFatherName());
        studentResDto1.setMotherName(student.getMotherName());
        studentResDto1.setNumber(student.getNumber());
        studentResDto1.setStudentId(student.getStudentId());
        studentResDto1.setRollNumber(student.getRollNumber());
        studentResDto1.setTotalFees(fees.getTotalFees());
        studentResDto1.setAge(student.getAge());

        return studentResDto1;

    }

    public StudentResDto getById(Long id){
        Student student = studentRepo.findStudent(id);

        StudentResDto studentResDto1 = new StudentResDto();
        studentResDto1.setName(student.getName());
        studentResDto1.setStudentClass(student.getStudentClass());
        studentResDto1.setEmail(student.getEmail());
        studentResDto1.setAddress(student.getAddress());
        studentResDto1.setFatherName(student.getFatherName());
        studentResDto1.setMotherName(student.getMotherName());
        studentResDto1.setNumber(student.getNumber());
        studentResDto1.setStudentId(student.getStudentId());
        studentResDto1.setRollNumber(student.getRollNumber());
        studentResDto1.setTotalFees(student.getFees().getTotalFees());
        studentResDto1.setAge(student.getAge());
        return studentResDto1;
    }

    public StudentResDto updateStudent(Long id , StudentReqDto studentReqDto){
       Student student1 = studentRepo.findById(id).orElseThrow(()->new StudentNotFoundException("Student Id Does Not match"));
        Fees fees = feesRepository.findById(id).orElseThrow(()->new StudentNotFoundException("Fees Id Did not match"));
        if (!Objects.equals(student1.getRollNumber(), studentReqDto.getRollNumber())){
            throw new StudentNotFoundException("Student Not Found");
        }
        student1.setName(studentReqDto.getName());
        student1.setStudentClass(studentReqDto.getStudentClass());
        student1.setEmail(studentReqDto.getEmail());
        student1.setAddress(studentReqDto.getAddress());
        student1.setFatherName(studentReqDto.getFatherName());
        student1.setMotherName(studentReqDto.getMotherName());
        student1.setNumber(studentReqDto.getNumber());
        student1.setRollNumber(studentReqDto.getRollNumber());
        fees.setTotalFees(studentReqDto.getTotalFees());
        System.out.println(studentReqDto.getTotalFees());
        student1.setAge(studentReqDto.getAge());

        fees = feesRepository.save(fees);
        student1.setFees(fees);
        FeesBackup feesBackup = feesBackUpRepo.getReferenceById(id);
        feesBackup.setTotalFees(fees.getTotalFees());
        feesBackUpRepo.save(feesBackup);

        student1 = studentRepo.save(student1);
        return getStudentResDto(student1 , fees);
    }

    private static StudentResDto getStudentResDto(Student student , Fees fees) {
        StudentResDto studentResDto1 = new StudentResDto();

        studentResDto1.setName(student.getName());
        studentResDto1.setStudentClass(student.getStudentClass());
        studentResDto1.setEmail(student.getEmail());
        studentResDto1.setAddress(student.getAddress());
        studentResDto1.setFatherName(student.getFatherName());
        studentResDto1.setMotherName(student.getMotherName());
        studentResDto1.setNumber(student.getNumber());
        studentResDto1.setStudentId(student.getStudentId());
        studentResDto1.setRollNumber(student.getRollNumber());
        studentResDto1.setTotalFees(fees.getTotalFees());
        System.out.println(fees.getTotalFees());
        studentResDto1.setAge(student.getAge());
        return studentResDto1;
    }


}