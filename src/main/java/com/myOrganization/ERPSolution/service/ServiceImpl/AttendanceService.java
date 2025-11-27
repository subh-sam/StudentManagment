package com.myOrganization.ERPSolution.service.ServiceImpl;

import com.myOrganization.ERPSolution.Exception.AttendanceNotFoundException;
import com.myOrganization.ERPSolution.Exception.StudentNotFoundException;
import com.myOrganization.ERPSolution.dto.AttendanceStatus;
import com.myOrganization.ERPSolution.dto.attendanceDto.AttendanceReqDto;
import com.myOrganization.ERPSolution.dto.attendanceDto.AttendanceResDto;
import com.myOrganization.ERPSolution.dto.attendanceDto.AttendanceUpdateReqDto;
import com.myOrganization.ERPSolution.model.Attendance;
import com.myOrganization.ERPSolution.model.Student;
import com.myOrganization.ERPSolution.repository.AttendanceRepository;
import com.myOrganization.ERPSolution.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AttendanceService {
    @Autowired
    AttendanceRepository attendanceRepository;
    @Autowired
    StudentRepo studentRepo;

    // For Student

    public List<AttendanceResDto> getAttendanceById(Long studentId){

        Student student = studentRepo.findById(studentId)
                .orElseThrow(() -> new StudentNotFoundException("StudentId is incorrect"));

        // Best practice → get attendance from repository
        List<Attendance> attendanceList = attendanceRepository.findByStudentStudentId(studentId);

        if (attendanceList.isEmpty()){
            throw new StudentNotFoundException("Student Id Did not match with dataBase");
        }

        List<AttendanceResDto> resList = new ArrayList<>();

        for (Attendance attendance : attendanceList) {
            AttendanceResDto dto = new AttendanceResDto();
            dto.setAttendanceId(attendance.getAttendanceId());
            dto.setStudentName(student.getName());
            dto.setStudentClass(attendance.getStudentClass());
            dto.setRollNumber(student.getRollNumber());
            dto.setDate(attendance.getDate());
            dto.setStatus(attendance.getStatus());
            dto.setStudentId(attendance.getStudent().getStudentId());
            resList.add(dto);
        }

        return resList;
    }

    // For Teacher

    public List<AttendanceResDto> getAttendanceByDateAndClass(AttendanceReqDto attendanceReqDto){
        Integer studentClass = attendanceReqDto.getStudentClass();
        LocalDate date = attendanceReqDto.getDate();
        List<Attendance> attendanceList = attendanceRepository.listOfAttendance(studentClass,date);
        List<AttendanceResDto> resList = new ArrayList<>();

        if (attendanceList.isEmpty()){
           throw  new AttendanceNotFoundException("No Attendance Found for this class and Date");
        }else {

            for (Attendance attendance : attendanceList) {
                AttendanceResDto dto = new AttendanceResDto();
                dto.setAttendanceId(attendance.getAttendanceId());
                dto.setStudentName(attendance.getStudentName());
                dto.setStudentClass(attendance.getStudentClass());
                dto.setRollNumber(attendance.getRollNumber());
                dto.setDate(attendance.getDate());
                dto.setStatus(attendance.getStatus());
                dto.setStudentId(attendance.getStudent().getStudentId());
                resList.add(dto);
            }

            return resList;
        }
    }

    // For Student

    public List<AttendanceResDto> getAttendanceByClass(Integer studentClass){
//        List<Attendance> attendanceList = attendanceRepository.listOfAttendanceByDate(studentClass);
        List<Student> students = studentRepo.findStudentByClass(studentClass);
        List<AttendanceResDto> resList = new ArrayList<>();
        if(students.isEmpty()){
            throw new AttendanceNotFoundException("Student class Have no Attendance");
        }

        for (Student attendance : students) {
            AttendanceResDto dto = new AttendanceResDto();
            dto.setAttendanceId(attendance.getAttendance().getLast().getAttendanceId());
            dto.setStudentName(attendance.getName());
            dto.setStudentClass(attendance.getStudentClass());
            dto.setRollNumber(attendance.getRollNumber());
            dto.setDate(null);
            dto.setStatus(null);
            dto.setStudentId(attendance.getStudentId());
            resList.add(dto);
        }

        return resList;
    }

    public List<AttendanceResDto> updateAttendance (List<AttendanceUpdateReqDto> attendanceUpdateReqDtos) {

        List<AttendanceResDto> resList = new ArrayList<>();

       for(AttendanceUpdateReqDto attendanceUpdateReqDto : attendanceUpdateReqDtos){

           Attendance attendance = attendanceRepository.findById(attendanceUpdateReqDto.getAttendanceId()).orElseThrow(()->new StudentNotFoundException("Student Id Not match"+attendanceUpdateReqDto.getAttendanceId()));
           attendance.setStatus(attendanceUpdateReqDto.getStatus());
           attendance = attendanceRepository.save(attendance);

           AttendanceResDto dto = new AttendanceResDto();

           dto.setAttendanceId(attendance.getAttendanceId());
           dto.setStudentName(attendance.getStudentName());
           dto.setStudentClass(attendance.getStudentClass());
           dto.setRollNumber(attendance.getRollNumber());
           dto.setDate(attendance.getDate());
           dto.setStatus(attendance.getStatus());
           dto.setStudentId(attendance.getStudent().getStudentId());
           resList.add(dto);
       }
       return resList;
    }

    public List<AttendanceResDto> takeAttendance(List<AttendanceReqDto> attendanceReqDto){

        List<AttendanceResDto>attendanceList = new ArrayList<>();

        for(AttendanceReqDto attendanceReqDto1 :attendanceReqDto){

            Attendance attendance = attendanceRepository.getReferenceById(attendanceReqDto1.getAttendanceId());
            LocalDate date = attendanceReqDto1.getDate();
            AttendanceStatus status = attendanceReqDto1.getStatus();

            Attendance attendance1 = new Attendance();
            attendance1.setStudentName(attendance.getStudentName());
            attendance1.setStudentClass(attendance.getStudentClass());
            attendance1.setRollNumber(attendance.getRollNumber());
            attendance1.setStatus(status);
            attendance1.setDate(date);
            attendance1.setStudent(attendance.getStudent());
            attendance1.setAttendanceId(attendance1.getAttendanceId());

            attendance1 = attendanceRepository.save(attendance1);

            AttendanceResDto dto = new AttendanceResDto();
            dto.setAttendanceId(attendance1.getAttendanceId());
            dto.setStudentName(attendance1.getStudentName());
            dto.setStudentClass(attendance1.getStudentClass());
            dto.setRollNumber(attendance1.getRollNumber());
            dto.setDate(attendance1.getDate());
            dto.setStatus(attendance1.getStatus());
            System.out.println(attendance1.getStudent().getStudentId());
            dto.setStudentId(attendance1.getStudent().getStudentId());

            attendanceList.add(dto);

//            Integer studentClass = attendanceReqDto1.getStudentClass();
//            LocalDate date = attendanceReqDto1.getDate();
//            AttendanceStatus status = attendanceReqDto1.getStatus();
//            Attendance attendance = new Attendance();
//
//            attendance.setStatus(status);
//            attendance.setStudentClass(studentClass);
//            attendance.setDate(date);
//
//            attendance.setRollNumber(attendanceReqDto1.getRollNumber());
//            Attendance attendanceID = attendanceRepository.getReferenceById(attendanceReqDto1.getAttendanceId());
//            attendance.setAttendanceId(attendanceReqDto1.getAttendanceId());
//            attendance.setStudentName(attendanceReqDto1.getStudentName());
//            attendance.setStudent(attendanceID.getStudent());
//            attendance = attendanceRepository.save(attendance);
//
//            AttendanceResDto dto = new AttendanceResDto();
//            dto.setAttendanceId(attendance.getAttendanceId());
//            dto.setStudentName(attendance.getStudentName());
//            dto.setStudentClass(attendance.getStudentClass());
//            dto.setRollNumber(attendance.getRollNumber());
//            dto.setDate(attendance.getDate());
//            dto.setStatus(attendance.getStatus());
//            System.out.println(attendance.getStudent().getStudentId());
//            dto.setStudentId(attendance.getStudent().getStudentId());
//            attendanceList.add(dto);
        }
        return attendanceList;
    }

}