package com.jrm.chronos.core.service;

import com.jrm.chronos.core.dto.ShiftAssignmentDto;
import com.jrm.chronos.core.dto.ShiftCreateDto;
import com.jrm.chronos.core.dto.ShiftDto;

import java.util.List;

public interface SchedulingService {
    ShiftDto createShift(ShiftCreateDto shiftCreateDto);
    ShiftAssignmentDto assignShift(Long shiftId, Long employeeId);
    List<ShiftDto> findOpenShifts();
    List<ShiftDto> findShiftsByLocation(Long locationId);
    void cancelShift(Long shiftId);
}
