package com.jrm.chronos.core.dto;

import com.jrm.chronos.domain.enums.ShiftStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShiftDto {
    private Long id;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Long locationId;
    private String locationName;
    private Long departmentId;
    private String departmentName;
    private Long requiredRoleId;
    private String requiredRoleName;
    private ShiftStatus status;
    private String notes;
}
