package com.jrm.chronos.domain.repository;

import com.jrm.chronos.domain.Sticky;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StickyRepository extends JpaRepository<Sticky, Long> {
    List<Sticky> findByOwnerUsername(String username);
    List<Sticky> findByCategory(String category);
}
