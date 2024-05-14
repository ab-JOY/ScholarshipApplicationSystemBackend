package com.SE102.ScholarshipApplicationSystem.repository;


import com.SE102.ScholarshipApplicationSystem.model.ScholarPending;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScholarPendingRepository extends JpaRepository<ScholarPending, Long> {
}
