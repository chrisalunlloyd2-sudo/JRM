package com.jrm.chronos.domain.repository;

import com.jrm.chronos.domain.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long>, QuerydslPredicateExecutor<Location> {
    Optional<Location> findByName(String name);
}
