package com.jrm.chronos.core.service.impl;

import com.jrm.chronos.core.dto.PayPeriodDto;
import com.jrm.chronos.core.dto.PaycheckDto;
import com.jrm.chronos.core.mapper.PayrollMapper;
import com.jrm.chronos.core.service.PayrollService;
import com.jrm.chronos.domain.EmployeeProfile;
import com.jrm.chronos.domain.PayPeriod;
import com.jrm.chronos.domain.Paycheck;
import com.jrm.chronos.domain.TimeEntry;
import com.jrm.chronos.domain.repository.EmployeeProfileRepository;
import com.jrm.chronos.domain.repository.PayPeriodRepository;
import com.jrm.chronos.domain.repository.PaycheckRepository;
import com.jrm.chronos.domain.repository.TimeEntryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PayrollServiceImpl implements PayrollService {

    private final PayPeriodRepository payPeriodRepository;
    private final PaycheckRepository paycheckRepository;
    private final TimeEntryRepository timeEntryRepository;
    private final EmployeeProfileRepository employeeProfileRepository;
    private final PayrollMapper payrollMapper;

    @Override
    @Transactional
    public PayPeriodDto createPayPeriod(PayPeriodDto payPeriodDto) {
        PayPeriod payPeriod = PayPeriod.builder()
                .startDate(payPeriodDto.getStartDate())
                .endDate(payPeriodDto.getEndDate())
                .processed(false)
                .build();
        return payrollMapper.toDto(payPeriodRepository.save(payPeriod));
    }

    @Override
    @Transactional
    public void processPayroll(Long payPeriodId) {
        PayPeriod payPeriod = payPeriodRepository.findById(payPeriodId)
                .orElseThrow(() -> new RuntimeException("Pay period not found"));

        if (payPeriod.isProcessed()) {
            throw new RuntimeException("Pay period already processed");
        }

        List<EmployeeProfile> employees = employeeProfileRepository.findAll();
        LocalDateTime start = payPeriod.getStartDate().atStartOfDay();
        LocalDateTime end = payPeriod.getEndDate().plusDays(1).atStartOfDay();

        for (EmployeeProfile employee : employees) {
            List<TimeEntry> entries = timeEntryRepository.findByEmployeeIdAndClockInBetween(employee.getId(), start, end);
            
            double totalHours = entries.stream()
                    .filter(TimeEntry::isVerified)
                    .filter(e -> e.getTotalHours() != null)
                    .mapToDouble(TimeEntry::getTotalHours)
                    .sum();

            if (totalHours > 0) {
                // Simplified calculation logic: $25/hr base rate for prototype
                BigDecimal rate = new BigDecimal("25.00");
                BigDecimal grossPay = rate.multiply(BigDecimal.valueOf(totalHours));
                BigDecimal deductions = grossPay.multiply(new BigDecimal("0.20")); // 20% tax/deductions
                BigDecimal netPay = grossPay.subtract(deductions);

                Paycheck paycheck = Paycheck.builder()
                        .employee(employee)
                        .payPeriod(payPeriod)
                        .grossPay(grossPay)
                        .totalDeductions(deductions)
                        .netPay(netPay)
                        .issuedDate(LocalDateTime.now())
                        .notes("Automated generation for " + totalHours + " hours")
                        .build();

                paycheckRepository.save(paycheck);
            }
        }

        payPeriod.setProcessed(true);
        payPeriodRepository.save(payPeriod);
    }

    @Override
    public List<PaycheckDto> findPaychecksByEmployee(Long employeeId) {
        return paycheckRepository.findByEmployeeId(employeeId).stream()
                .map(payrollMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<PaycheckDto> findPaychecksByPeriod(Long payPeriodId) {
        return paycheckRepository.findByPayPeriodId(payPeriodId).stream()
                .map(payrollMapper::toDto)
                .collect(Collectors.toList());
    }
}
