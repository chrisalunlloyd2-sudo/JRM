package com.jrm.chronos.domain.repository;

import com.jrm.chronos.domain.Shift;
import com.jrm.chronos.domain.enums.ShiftStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ShiftRepository extends JpaRepository<Shift, Long>, QuerydslPredicateExecutor<Shift> {
    List<Shift> findByStatus(ShiftStatus status);
    List<Shift> findByStartTimeBetween(LocalDateTime start, LocalDateTime end);
    List<Shift> findByLocationId(Long locationId);
}
