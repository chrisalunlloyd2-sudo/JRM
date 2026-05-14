package com.jrm.chronos.domain.repository;

import com.jrm.chronos.domain.TimeEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TimeEntryRepository extends JpaRepository<TimeEntry, Long>, QuerydslPredicateExecutor<TimeEntry> {
    List<TimeEntry> findByEmployeeId(Long employeeId);
    List<TimeEntry> findByClockInBetween(LocalDateTime start, LocalDateTime end);
    List<TimeEntry> findByEmployeeIdAndClockInBetween(Long employeeId, LocalDateTime start, LocalDateTime end);
}
