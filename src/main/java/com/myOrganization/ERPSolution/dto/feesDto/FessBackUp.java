package com.myOrganization.ERPSolution.dto.feesDto;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class FessBackUp {

    private Long studentId;
    private String studentName;
    private Integer totalFees;
    private Integer paidFees;
    private LocalDate lastPaymentDate;

}
