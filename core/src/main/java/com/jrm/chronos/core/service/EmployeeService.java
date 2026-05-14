package com.jrm.chronos.core.service;

import com.jrm.chronos.core.dto.EmployeeProfileDto;
import java.util.List;

public interface EmployeeService {
    EmployeeProfileDto findById(Long id);
    EmployeeProfileDto findByEmployeeNumber(String employeeNumber);
    List<EmployeeProfileDto> findAll();
}
