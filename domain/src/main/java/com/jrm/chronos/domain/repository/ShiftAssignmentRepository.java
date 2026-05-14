package com.jrm.chronos.domain.repository;

import com.jrm.chronos.domain.ShiftAssignment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShiftAssignmentRepository extends JpaRepository<ShiftAssignment, Long>, QuerydslPredicateExecutor<ShiftAssignment> {
    Optional<ShiftAssignment> findByShiftId(Long shiftId);
    java.util.List<ShiftAssignment> findByEmployeeId(Long employeeId);
}
