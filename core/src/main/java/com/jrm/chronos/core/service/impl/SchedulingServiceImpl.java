package com.jrm.chronos.core.service.impl;

import com.jrm.chronos.core.dto.ShiftAssignmentDto;
import com.jrm.chronos.core.dto.ShiftCreateDto;
import com.jrm.chronos.core.dto.ShiftDto;
import com.jrm.chronos.core.mapper.ShiftMapper;
import com.jrm.chronos.core.service.SchedulingService;
import com.jrm.chronos.domain.EmployeeProfile;
import com.jrm.chronos.domain.Shift;
import com.jrm.chronos.domain.ShiftAssignment;
import com.jrm.chronos.domain.enums.ShiftStatus;
import com.jrm.chronos.domain.repository.EmployeeProfileRepository;
import com.jrm.chronos.domain.repository.ShiftAssignmentRepository;
import com.jrm.chronos.domain.repository.ShiftRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SchedulingServiceImpl implements SchedulingService {

    private final ShiftRepository shiftRepository;
    private final ShiftAssignmentRepository shiftAssignmentRepository;
    private final EmployeeProfileRepository employeeProfileRepository;
    private final ShiftMapper shiftMapper;

    @Override
    @Transactional
    public ShiftDto createShift(ShiftCreateDto shiftCreateDto) {
        Shift shift = shiftMapper.toEntity(shiftCreateDto);
        shift.setStatus(ShiftStatus.OPEN);
        return shiftMapper.toDto(shiftRepository.save(shift));
    }

    @Override
    @Transactional
    public ShiftAssignmentDto assignShift(Long shiftId, Long employeeId) {
        Shift shift = shiftRepository.findById(shiftId)
                .orElseThrow(() -> new RuntimeException("Shift not found"));
        
        EmployeeProfile employee = employeeProfileRepository.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        if (shift.getStatus() == ShiftStatus.ASSIGNED) {
            throw new RuntimeException("Shift already assigned");
        }

        ShiftAssignment assignment = ShiftAssignment.builder()
                .shift(shift)
                .employee(employee)
                .assignedAt(LocalDateTime.now())
                .build();

        shift.setStatus(ShiftStatus.ASSIGNED);
        shiftRepository.save(shift);

        return shiftMapper.toDto(shiftAssignmentRepository.save(assignment));
    }

    @Override
    public List<ShiftDto> findOpenShifts() {
        return shiftRepository.findByStatus(ShiftStatus.OPEN).stream()
                .map(shiftMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ShiftDto> findShiftsByLocation(Long locationId) {
        return shiftRepository.findByLocationId(locationId).stream()
                .map(shiftMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void cancelShift(Long shiftId) {
        Shift shift = shiftRepository.findById(shiftId)
                .orElseThrow(() -> new RuntimeException("Shift not found"));
        shift.setStatus(ShiftStatus.CANCELLED);
        shiftRepository.save(shift);
    }
}
