package com.myOrganization.ERPSolution.dto.attendanceDto;

import com.myOrganization.ERPSolution.dto.AttendanceStatus;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class AttendanceUpdateReqDto {
    private Long attendanceId;
    @NotNull(message = "Date Must Be Fill")
    private LocalDate date;
    @NotNull(message = "Status Not Be Empty")
    private AttendanceStatus status;

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

    public Long getAttendanceId() {
        return attendanceId;
    }

    public void setAttendanceId(Long attendanceId) {
        this.attendanceId = attendanceId;
    }
}
