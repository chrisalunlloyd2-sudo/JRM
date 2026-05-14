package com.jrm.chronos.domain.repository;

import com.jrm.chronos.domain.ShiftBid;
import com.jrm.chronos.domain.enums.BidStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShiftBidRepository extends JpaRepository<ShiftBid, Long>, QuerydslPredicateExecutor<ShiftBid> {
    List<ShiftBid> findByShiftId(Long shiftId);
    List<ShiftBid> findByEmployeeId(Long employeeId);
    List<ShiftBid> findByShiftIdAndStatus(Long shiftId, BidStatus status);
}
