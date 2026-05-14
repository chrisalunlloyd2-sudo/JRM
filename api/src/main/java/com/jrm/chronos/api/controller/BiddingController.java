package com.jrm.chronos.api.controller;

import com.jrm.chronos.core.dto.ShiftBidDto;
import com.jrm.chronos.core.service.BiddingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bidding")
@RequiredArgsConstructor
public class BiddingController {

    private final BiddingService biddingService;

    @PostMapping("/shifts/{shiftId}/bids")
    public ResponseEntity<ShiftBidDto> placeBid(@PathVariable Long shiftId, 
                                                @RequestParam Long employeeId, 
                                                @RequestBody(required = false) String notes) {
        return ResponseEntity.ok(biddingService.placeBid(shiftId, employeeId, notes));
    }

    @PostMapping("/bids/{bidId}/accept")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ShiftBidDto> acceptBid(@PathVariable Long bidId) {
        return ResponseEntity.ok(biddingService.acceptBid(bidId));
    }

    @PostMapping("/bids/{bidId}/reject")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ShiftBidDto> rejectBid(@PathVariable Long bidId) {
        return ResponseEntity.ok(biddingService.rejectBid(bidId));
    }

    @GetMapping("/shifts/{shiftId}/bids")
    public ResponseEntity<List<ShiftBidDto>> findBidsByShift(@PathVariable Long shiftId) {
        return ResponseEntity.ok(biddingService.findBidsByShift(shiftId));
    }
}
