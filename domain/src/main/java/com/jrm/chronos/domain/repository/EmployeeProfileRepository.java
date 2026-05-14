package com.jrm.chronos.domain.repository;

import com.jrm.chronos.domain.EmployeeProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeProfileRepository extends JpaRepository<EmployeeProfile, Long>, QuerydslPredicateExecutor<EmployeeProfile> {
    Optional<EmployeeProfile> findByEmployeeNumber(String employeeNumber);
    Optional<EmployeeProfile> findByUserId(Long userId);
}
