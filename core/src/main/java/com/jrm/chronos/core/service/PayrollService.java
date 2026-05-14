package com.jrm.chronos.core.service;

import com.jrm.chronos.core.dto.PayPeriodDto;
import com.jrm.chronos.core.dto.PaycheckDto;
import java.util.List;

public interface PayrollService {
    PayPeriodDto createPayPeriod(PayPeriodDto payPeriodDto);
    void processPayroll(Long payPeriodId);
    List<PaycheckDto> findPaychecksByEmployee(Long employeeId);
    List<PaycheckDto> findPaychecksByPeriod(Long payPeriodId);
}
