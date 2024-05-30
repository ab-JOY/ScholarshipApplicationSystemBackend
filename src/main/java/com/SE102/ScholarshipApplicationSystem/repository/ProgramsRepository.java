package com.SE102.ScholarshipApplicationSystem.repository;

import com.SE102.ScholarshipApplicationSystem.model.Programs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgramsRepository extends JpaRepository<Programs, Long> {
}
