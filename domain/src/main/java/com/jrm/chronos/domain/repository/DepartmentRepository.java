package com.jrm.chronos.domain.repository;

import com.jrm.chronos.domain.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long>, QuerydslPredicateExecutor<Department> {
    List<Department> findByLocationId(Long locationId);
}
