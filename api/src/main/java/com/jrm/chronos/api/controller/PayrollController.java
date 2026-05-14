package com.jrm.chronos.api.controller;

import com.jrm.chronos.core.dto.PaycheckDto;
import com.jrm.chronos.core.dto.TimeEntryDto;
import com.jrm.chronos.core.service.PayrollService;
import com.jrm.chronos.core.service.TimeEntryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payroll")
@RequiredArgsConstructor
public class PayrollController {

    private final TimeEntryService timeEntryService;
    private final PayrollService payrollService;

    @PostMapping("/clock-in")
    public ResponseEntity<TimeEntryDto> clockIn(@RequestParam Long employeeId, @RequestParam(required = false) Long shiftId) {
        return ResponseEntity.ok(timeEntryService.clockIn(employeeId, shiftId));
    }

    @PostMapping("/clock-out/{timeEntryId}")
    public ResponseEntity<TimeEntryDto> clockOut(@PathVariable Long timeEntryId) {
        return ResponseEntity.ok(timeEntryService.clockOut(timeEntryId));
    }

    @PostMapping("/process/{payPeriodId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> processPayroll(@PathVariable Long payPeriodId) {
        payrollService.processPayroll(payPeriodId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/employee/{employeeId}/paychecks")
    public ResponseEntity<List<PaycheckDto>> getEmployeePaychecks(@PathVariable Long employeeId) {
        return ResponseEntity.ok(payrollService.findPaychecksByEmployee(employeeId));
    }
}
