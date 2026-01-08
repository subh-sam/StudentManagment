package com.myOrganization.ERPSolution.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "Student")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;

    @Column(nullable = false ,unique = true)
    private Integer rollNumber;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private Integer studentClass;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String fatherName;

    @Column(nullable = false)
    private String motherName;

    @Column(name = "Number" ,nullable = false)
    private String number;

    @Column(nullable = false)
    private String email;

    @Column(nullable = true)
    private String address;

    @Column(nullable = false)
    private Integer age;

    @OneToOne(mappedBy = "student")
    private Marks marks;

    @OneToOne(mappedBy = "student")
    private Fees fees;

    @OneToMany(mappedBy = "student")
    private List<Attendance> attendance ;

}
