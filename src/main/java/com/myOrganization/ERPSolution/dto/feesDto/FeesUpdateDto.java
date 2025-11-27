package com.myOrganization.ERPSolution.dto.feesDto;

import com.myOrganization.ERPSolution.model.Student;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class FeesUpdateDto {
    private Integer paidFees;
    private LocalDate lastPaymentDate;

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
}
