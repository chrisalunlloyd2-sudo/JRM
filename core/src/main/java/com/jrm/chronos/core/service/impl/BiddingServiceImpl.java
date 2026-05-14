package com.jrm.chronos.core.service.impl;

import com.jrm.chronos.core.dto.ShiftBidDto;
import com.jrm.chronos.core.mapper.BiddingMapper;
import com.jrm.chronos.core.service.BiddingService;
import com.jrm.chronos.core.service.SchedulingService;
import com.jrm.chronos.domain.EmployeeProfile;
import com.jrm.chronos.domain.Shift;
import com.jrm.chronos.domain.ShiftBid;
import com.jrm.chronos.domain.enums.BidStatus;
import com.jrm.chronos.domain.enums.ShiftStatus;
import com.jrm.chronos.domain.repository.EmployeeProfileRepository;
import com.jrm.chronos.domain.repository.ShiftBidRepository;
import com.jrm.chronos.domain.repository.ShiftRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BiddingServiceImpl implements BiddingService {

    private final ShiftBidRepository shiftBidRepository;
    private final ShiftRepository shiftRepository;
    private final EmployeeProfileRepository employeeProfileRepository;
    private final SchedulingService schedulingService;
    private final BiddingMapper biddingMapper;

    @Override
    @Transactional
    public ShiftBidDto placeBid(Long shiftId, Long employeeId, String notes) {
        Shift shift = shiftRepository.findById(shiftId)
                .orElseThrow(() -> new RuntimeException("Shift not found"));
        EmployeeProfile employee = employeeProfileRepository.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        if (shift.getStatus() != ShiftStatus.OPEN && shift.getStatus() != ShiftStatus.BIDDING) {
            throw new RuntimeException("Shift is not open for bidding");
        }

        ShiftBid bid = ShiftBid.builder()
                .shift(shift)
                .employee(employee)
                .bidTime(LocalDateTime.now())
                .status(BidStatus.PENDING)
                .notes(notes)
                .build();

        shift.setStatus(ShiftStatus.BIDDING);
        shiftRepository.save(shift);

        return biddingMapper.toDto(shiftBidRepository.save(bid));
    }

    @Override
    @Transactional
    public ShiftBidDto acceptBid(Long bidId) {
        ShiftBid bid = shiftBidRepository.findById(bidId)
                .orElseThrow(() -> new RuntimeException("Bid not found"));

        if (bid.getStatus() != BidStatus.PENDING) {
            throw new RuntimeException("Bid is not pending");
        }

        bid.setStatus(BidStatus.ACCEPTED);
        shiftBidRepository.save(bid);

        // Assign the shift
        schedulingService.assignShift(bid.getShift().getId(), bid.getEmployee().getId());

        // Reject other bids for the same shift
        List<ShiftBid> otherBids = shiftBidRepository.findByShiftIdAndStatus(bid.getShift().getId(), BidStatus.PENDING);
        otherBids.forEach(otherBid -> {
            if (!otherBid.getId().equals(bidId)) {
                otherBid.setStatus(BidStatus.REJECTED);
                shiftBidRepository.save(otherBid);
            }
        });

        return biddingMapper.toDto(bid);
    }

    @Override
    @Transactional
    public ShiftBidDto rejectBid(Long bidId) {
        ShiftBid bid = shiftBidRepository.findById(bidId)
                .orElseThrow(() -> new RuntimeException("Bid not found"));
        bid.setStatus(BidStatus.REJECTED);
        return biddingMapper.toDto(shiftBidRepository.save(bid));
    }

    @Override
    public List<ShiftBidDto> findBidsByShift(Long shiftId) {
        return shiftBidRepository.findByShiftId(shiftId).stream()
                .map(biddingMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ShiftBidDto> findBidsByEmployee(Long employeeId) {
        return shiftBidRepository.findByEmployeeId(employeeId).stream()
                .map(biddingMapper::toDto)
                .collect(Collectors.toList());
    }
}
