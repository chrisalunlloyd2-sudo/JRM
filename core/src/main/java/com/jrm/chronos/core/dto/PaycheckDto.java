package com.jrm.chronos.core.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaycheckDto {
    private Long id;
    private Long employeeId;
    private String employeeName;
    private Long payPeriodId;
    private BigDecimal grossPay;
    private BigDecimal netPay;
    private BigDecimal totalDeductions;
    private LocalDateTime issuedDate;
}
