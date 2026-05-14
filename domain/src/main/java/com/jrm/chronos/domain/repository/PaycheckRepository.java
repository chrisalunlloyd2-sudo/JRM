package com.jrm.chronos.domain.repository;

import com.jrm.chronos.domain.Paycheck;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaycheckRepository extends JpaRepository<Paycheck, Long>, QuerydslPredicateExecutor<Paycheck> {
    List<Paycheck> findByEmployeeId(Long employeeId);
    List<Paycheck> findByPayPeriodId(Long payPeriodId);
}
