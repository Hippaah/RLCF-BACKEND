package com.rlcf.spring.repository;

import com.rlcf.spring.models.Demand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DemandRepository extends JpaRepository<Demand,Long> {
}
