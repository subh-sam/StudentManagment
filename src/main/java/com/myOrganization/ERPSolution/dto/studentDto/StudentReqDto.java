package com.myOrganization.ERPSolution.dto.studentDto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentReqDto {
    @NotNull(message = "Student class is required")
    @Min(value = 1, message = "Student class must be in between 1–12")
    @Max(value = 12, message = "Student class must be in between 1–12")
    private Integer studentClass;

    @NotNull(message = "Student RollNumber must be assign Serially")
    private Integer rollNumber;
    @NotNull(message = "Student name cannot be empty")
    private String name;
    @NotBlank(message = "Email cannot be empty")
    @Email(message = "Email format is invalid")
    private String email;
    @NotNull(message = "Student fatherName cannot be empty")
    private String fatherName;
    @NotNull(message = "Student motherName cannot be empty")
    private String motherName;
    @NotBlank(message = "Student phone number cannot be empty")
    @Pattern(regexp = "^[0-9]{10}$", message = "Phone number must be exactly 10 digits")
    private String number;

    @NotNull(message = "Student address cannot be empty")
    private String address;

    @NotNull(message = "Fees is not null")
    private Integer totalFees;

    @NotNull(message = "Age is not null")
    private Integer age;

}
