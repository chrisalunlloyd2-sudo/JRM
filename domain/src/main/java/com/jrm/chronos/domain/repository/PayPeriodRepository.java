package com.jrm.chronos.domain.repository;

import com.jrm.chronos.domain.PayPeriod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface PayPeriodRepository extends JpaRepository<PayPeriod, Long>, QuerydslPredicateExecutor<PayPeriod> {
    Optional<PayPeriod> findByStartDateAndEndDate(LocalDate startDate, LocalDate endDate);
}
