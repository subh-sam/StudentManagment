package com.myOrganization.ERPSolution.model.teacher;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.UniqueElements;

@Entity
@Table(name = "Teacher")
@Data
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    private String name;
    @Column(unique = true , nullable = false)
    private String phone;
    @Column(nullable = false,unique = true)
    private String password;
}