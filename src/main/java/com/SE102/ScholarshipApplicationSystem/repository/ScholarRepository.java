package com.SE102.ScholarshipApplicationSystem.repository;

import com.SE102.ScholarshipApplicationSystem.model.Scholar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ScholarRepository extends JpaRepository<Scholar, Long> {
    Optional<Scholar> findByEmailAddress(String emailAddress);
}
