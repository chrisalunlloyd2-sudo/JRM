package com.jrm.chronos.core.service.impl;

import com.jrm.chronos.core.dto.EmployeeProfileDto;
import com.jrm.chronos.core.mapper.EmployeeMapper;
import com.jrm.chronos.core.service.EmployeeService;
import com.jrm.chronos.domain.repository.EmployeeProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeProfileRepository employeeProfileRepository;
    private final EmployeeMapper employeeMapper;

    @Override
    public EmployeeProfileDto findById(Long id) {
        return employeeProfileRepository.findById(id)
                .map(employeeMapper::toDto)
                .orElseThrow(() -> new RuntimeException("Employee profile not found with id: " + id));
    }

    @Override
    public EmployeeProfileDto findByEmployeeNumber(String employeeNumber) {
        return employeeProfileRepository.findByEmployeeNumber(employeeNumber)
                .map(employeeMapper::toDto)
                .orElseThrow(() -> new RuntimeException("Employee profile not found with number: " + employeeNumber));
    }

    @Override
    public List<EmployeeProfileDto> findAll() {
        return employeeProfileRepository.findAll().stream()
                .map(employeeMapper::toDto)
                .collect(Collectors.toList());
    }
}
