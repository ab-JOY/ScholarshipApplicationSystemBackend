package com.SE102.ScholarshipApplicationSystem.controller;

import com.SE102.ScholarshipApplicationSystem.model.DisbursedScholarship;
import com.SE102.ScholarshipApplicationSystem.model.Programs;
import com.SE102.ScholarshipApplicationSystem.repository.DisbursedScholarshipRepository;
import com.SE102.ScholarshipApplicationSystem.service.TransferDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class DisbursedScholarshipController {

    @Autowired
    private DisbursedScholarshipRepository disbursedScholarshipRepository;

    @Autowired
    private TransferDataService transferDataService;

    @PostMapping("/updateStatus/{programId_waiting}")
    public ResponseEntity<?> updateStatusToDisbursed(@PathVariable Long programId_waiting) {
        transferDataService.disbursedStatus(programId_waiting);
        return ResponseEntity.ok("Success");
    }

    @GetMapping("/disbursed/count")
    public Long getDisbursedCount(){return disbursedScholarshipRepository.count();}

    @GetMapping("/disbursedPrograms")
    List<DisbursedScholarship> getAllDisbursed(){
        return disbursedScholarshipRepository.findAll();
    }
}
