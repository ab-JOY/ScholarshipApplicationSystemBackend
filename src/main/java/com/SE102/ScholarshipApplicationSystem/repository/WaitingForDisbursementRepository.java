package com.SE102.ScholarshipApplicationSystem.repository;

import com.SE102.ScholarshipApplicationSystem.model.WaitingForDisbursement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WaitingForDisbursementRepository extends JpaRepository<WaitingForDisbursement,Long> {
}
