package com.jrm.chronos.core.service;

import com.jrm.chronos.core.dto.ShiftBidDto;

import java.util.List;

public interface BiddingService {
    ShiftBidDto placeBid(Long shiftId, Long employeeId, String notes);
    ShiftBidDto acceptBid(Long bidId);
    ShiftBidDto rejectBid(Long bidId);
    List<ShiftBidDto> findBidsByShift(Long shiftId);
    List<ShiftBidDto> findBidsByEmployee(Long employeeId);
}
