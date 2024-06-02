package com.SE102.ScholarshipApplicationSystem.repository;

import com.SE102.ScholarshipApplicationSystem.model.DisbursedScholarship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DisbursedScholarshipRepository extends JpaRepository<DisbursedScholarship, Long> {
}
