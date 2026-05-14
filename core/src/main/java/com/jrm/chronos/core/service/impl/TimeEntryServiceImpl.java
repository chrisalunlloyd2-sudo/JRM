package com.jrm.chronos.core.service.impl;

import com.jrm.chronos.core.dto.TimeEntryDto;
import com.jrm.chronos.core.mapper.TimeEntryMapper;
import com.jrm.chronos.core.service.TimeEntryService;
import com.jrm.chronos.domain.EmployeeProfile;
import com.jrm.chronos.domain.Shift;
import com.jrm.chronos.domain.TimeEntry;
import com.jrm.chronos.domain.repository.EmployeeProfileRepository;
import com.jrm.chronos.domain.repository.ShiftRepository;
import com.jrm.chronos.domain.repository.TimeEntryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TimeEntryServiceImpl implements TimeEntryService {

    private final TimeEntryRepository timeEntryRepository;
    private final EmployeeProfileRepository employeeProfileRepository;
    private final ShiftRepository shiftRepository;
    private final TimeEntryMapper timeEntryMapper;

    @Override
    @Transactional
    public TimeEntryDto clockIn(Long employeeId, Long shiftId) {
        EmployeeProfile employee = employeeProfileRepository.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
        
        Shift shift = (shiftId != null) ? shiftRepository.findById(shiftId).orElse(null) : null;

        TimeEntry entry = TimeEntry.builder()
                .employee(employee)
                .shift(shift)
                .clockIn(LocalDateTime.now())
                .verified(false)
                .build();

        return timeEntryMapper.toDto(timeEntryRepository.save(entry));
    }

    @Override
    @Transactional
    public TimeEntryDto clockOut(Long timeEntryId) {
        TimeEntry entry = timeEntryRepository.findById(timeEntryId)
                .orElseThrow(() -> new RuntimeException("Time entry not found"));

        if (entry.getClockOut() != null) {
            throw new RuntimeException("Already clocked out");
        }

        entry.setClockOut(LocalDateTime.now());
        
        // Calculate total hours
        long seconds = Duration.between(entry.getClockIn(), entry.getClockOut()).getSeconds();
        entry.setTotalHours(seconds / 3600.0);

        return timeEntryMapper.toDto(timeEntryRepository.save(entry));
    }

    @Override
    public List<TimeEntryDto> findByEmployee(Long employeeId) {
        return timeEntryRepository.findByEmployeeId(employeeId).stream()
                .map(timeEntryMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void verifyEntry(Long timeEntryId) {
        TimeEntry entry = timeEntryRepository.findById(timeEntryId)
                .orElseThrow(() -> new RuntimeException("Time entry not found"));
        entry.setVerified(true);
        timeEntryRepository.save(entry);
    }
}
