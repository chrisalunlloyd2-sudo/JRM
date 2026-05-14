package com.jrm.chronos.core.service;

import com.jrm.chronos.core.dto.TimeEntryDto;
import java.util.List;

public interface TimeEntryService {
    TimeEntryDto clockIn(Long employeeId, Long shiftId);
    TimeEntryDto clockOut(Long timeEntryId);
    List<TimeEntryDto> findByEmployee(Long employeeId);
    void verifyEntry(Long timeEntryId);
}
