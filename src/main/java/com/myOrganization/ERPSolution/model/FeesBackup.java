package com.myOrganization.ERPSolution.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Entity
@Table(name = "FeesBackup")
@Getter
@Setter
public class FeesBackup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long updatedFeesId;
    private Long studentId;
    private String studentName;
    private Integer totalFees;
    private Integer paidFees;
    private LocalDate lastPaymentDate;
    @JoinColumn(name = "studentForeignKey")
    @OneToOne()
    Fees fees;
}
