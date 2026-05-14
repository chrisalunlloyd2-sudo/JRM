package com.jrm.chronos.core.dto;

import com.jrm.chronos.domain.enums.BidStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShiftBidDto {
    private Long id;
    private Long shiftId;
    private Long employeeId;
    private String employeeName;
    private LocalDateTime bidTime;
    private BidStatus status;
    private String notes;
}
