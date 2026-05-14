package com.jrm.chronos.api.controller;

import com.jrm.chronos.core.dto.ShiftAssignmentDto;
import com.jrm.chronos.core.dto.ShiftCreateDto;
import com.jrm.chronos.core.dto.ShiftDto;
import com.jrm.chronos.core.service.SchedulingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/scheduling")
@RequiredArgsConstructor
public class SchedulingController {

    private final SchedulingService schedulingService;

    @PostMapping("/shifts")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ShiftDto> createShift(@RequestBody ShiftCreateDto shiftCreateDto) {
        return ResponseEntity.ok(schedulingService.createShift(shiftCreateDto));
    }

    @PostMapping("/shifts/{shiftId}/assign")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ShiftAssignmentDto> assignShift(@PathVariable Long shiftId, @RequestParam Long employeeId) {
        return ResponseEntity.ok(schedulingService.assignShift(shiftId, employeeId));
    }

    @GetMapping("/shifts/open")
    public ResponseEntity<List<ShiftDto>> findOpenShifts() {
        return ResponseEntity.ok(schedulingService.findOpenShifts());
    }

    @GetMapping("/locations/{locationId}/shifts")
    public ResponseEntity<List<ShiftDto>> findShiftsByLocation(@PathVariable Long locationId) {
        return ResponseEntity.ok(schedulingService.findShiftsByLocation(locationId));
    }

    @PostMapping("/shifts/{shiftId}/cancel")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> cancelShift(@PathVariable Long shiftId) {
        schedulingService.cancelShift(shiftId);
        return ResponseEntity.ok().build();
    }
}
