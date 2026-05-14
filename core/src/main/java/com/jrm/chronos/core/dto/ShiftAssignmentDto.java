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
public class ShiftAssignmentDto {
    private Long id;
    private Long shiftId;
    private Long employeeId;
    private String employeeName;
    private LocalDateTime assignedAt;
    private String notes;
}
