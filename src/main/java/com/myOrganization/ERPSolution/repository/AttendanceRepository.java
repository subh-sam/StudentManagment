package com.myOrganization.ERPSolution.repository;

import com.myOrganization.ERPSolution.dto.attendanceDto.AttendanceUpdateReqDto;
import com.myOrganization.ERPSolution.model.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {

    List<Attendance> findByStudentStudentId(Long studentId);
    @Query(value = "select * from attendance where student_class =:student_class", nativeQuery = true)
    List<Attendance> listOfAttendanceByDate(@Param("student_class") Integer student_class);

    @Query(value = "select * from attendance where student_class =:studentClass AND date =:date", nativeQuery = true)
    List<Attendance> listOfAttendance(@Param("studentClass") Integer studentClass, @Param("date")LocalDate date);

//    @Query(value = "update set ")
//   void updateAttendance(Integer studentClass, LocalDate date, List<AttendanceUpdateReqDto> attendanceUpdateReqDtos);

}