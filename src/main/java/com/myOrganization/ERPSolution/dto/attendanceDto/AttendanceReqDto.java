package com.myOrganization.ERPSolution.dto.attendanceDto;

import com.myOrganization.ERPSolution.dto.AttendanceStatus;
import com.myOrganization.ERPSolution.model.Student;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class AttendanceReqDto {
    @NotNull(message = "Date Must Be Fill")
    private LocalDate date;
    @NotNull(message = "Status Not Be Empty")
    private AttendanceStatus status;
    @NotNull(message = "Student Id Must be required Or Student Is not exist to this StudentID")
    @NotBlank(message = "Student must be between 1-12")
    private Long studentId;

    @Min(value = 1, message = "Class must be minimum 1")
    @Max(value = 12, message = "Class cannot be more than 12")
    private Integer studentClass;

    private Long attendanceId;

    private String studentName;

    private Integer rollNumber;
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public AttendanceStatus getStatus() {
        return status;
    }

    public void setStatus(AttendanceStatus status) {
        this.status = status;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Integer getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(Integer studentClass) {
        this.studentClass = studentClass;
    }

    public Long getAttendanceId() {
        return attendanceId;
    }

    public void setAttendanceId(Long attendanceId) {
        this.attendanceId = attendanceId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Integer getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(Integer rollNumber) {
        this.rollNumber = rollNumber;
    }
}
