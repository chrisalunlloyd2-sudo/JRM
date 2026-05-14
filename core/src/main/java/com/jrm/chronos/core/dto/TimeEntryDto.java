package com.jrm.chronos.core.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TimeEntryDto {
    private Long id;
    private Long employeeId;
    private String employeeName;
    private Long shiftId;
    private LocalDateTime clockIn;
    private LocalDateTime clockOut;
    private Double totalHours;
    private boolean verified;
    private String notes;
}
