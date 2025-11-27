package com.myOrganization.ERPSolution.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "fees")
public class Fees {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long feesId;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private Integer totalFees;
    private Integer paidFees;

    @Column(length = 50)
    private LocalDate lastPaymentDate;

    @OneToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @OneToOne(mappedBy = "fees")
    private FeesBackup feesBackup;

    // getters & setters

}
