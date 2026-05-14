package com.jrm.chronos.core.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PayPeriodDto {
    private Long id;
    private LocalDate startDate;
    private LocalDate endDate;
    private boolean processed;
}
