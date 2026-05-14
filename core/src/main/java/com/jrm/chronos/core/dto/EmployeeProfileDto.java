package com.jrm.chronos.core.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeProfileDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String employeeNumber;
    private LocalDate dateOfBirth;
    private LocalDate hireDate;
    private Long userId;
    private Long departmentId;
    private Long locationId;
}
