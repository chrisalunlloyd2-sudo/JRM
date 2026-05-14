package com.jrm.chronos.core.service;

import com.jrm.chronos.core.dto.TimeEntryDto;
import com.jrm.chronos.core.service.impl.TimeEntryServiceImpl;
import com.jrm.chronos.domain.EmployeeProfile;
import com.jrm.chronos.domain.TimeEntry;
import com.jrm.chronos.domain.repository.EmployeeProfileRepository;
import com.jrm.chronos.domain.repository.TimeEntryRepository;
import com.jrm.chronos.core.mapper.TimeEntryMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TimeEntryServiceTest {
    @Mock private TimeEntryRepository timeEntryRepository;
    @Mock private EmployeeProfileRepository employeeProfileRepository;
    @Mock private TimeEntryMapper timeEntryMapper;
    @InjectMocks private TimeEntryServiceImpl timeEntryService;

    @Test
    void clockIn_ValidEmployee_CreatesEntry() {
        when(employeeProfileRepository.findById(1L)).thenReturn(Optional.of(new EmployeeProfile()));
        when(timeEntryRepository.save(any(TimeEntry.class))).thenReturn(new TimeEntry());
        when(timeEntryMapper.toDto(any(TimeEntry.class))).thenReturn(new TimeEntryDto());

        assertNotNull(timeEntryService.clockIn(1L, null));
    }
}
