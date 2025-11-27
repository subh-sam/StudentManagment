package com.myOrganization.ERPSolution.dto.feesDto;

import com.myOrganization.ERPSolution.model.Student;
import jakarta.persistence.Column;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class FeesResDto {
    private Long studentId;
    private String studentName;
    private Integer totalFees;
    private Integer paidFees;
    private LocalDate lastPaymentDate;


    public Integer getTotalFees() {
        return totalFees;
    }

    public void setTotalFees(Integer totalFees) {
        this.totalFees = totalFees;
    }

    public Integer getPaidFees() {
        return paidFees;
    }

    public void setPaidFees(Integer paidFees) {
        this.paidFees = paidFees;
    }

    public LocalDate getLastPaymentDate() {
        return lastPaymentDate;
    }

    public void setLastPaymentDate(LocalDate lastPaymentDate) {
        this.lastPaymentDate = lastPaymentDate;
    }


    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }
}
