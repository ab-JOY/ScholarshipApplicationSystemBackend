package com.SE102.ScholarshipApplicationSystem.controller;


import com.SE102.ScholarshipApplicationSystem.model.Programs;
import com.SE102.ScholarshipApplicationSystem.model.WaitingForDisbursement;
import com.SE102.ScholarshipApplicationSystem.repository.WaitingForDisbursementRepository;
import com.SE102.ScholarshipApplicationSystem.service.TransferDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class WaitingForDisbursementController {

    @Autowired
    private WaitingForDisbursementRepository waitingForDisbursementRepository;

    @Autowired
    private TransferDataService transferDataService;
    @PostMapping("/statusUpdate/{programId}")
    public ResponseEntity<?> updateStatusToWaiting(@PathVariable Long programId) {
        transferDataService.waitingStatus(programId);
        return ResponseEntity.ok("Success");
    }

    @GetMapping("/waiting/count")
    public Long getWaitingCount(){return waitingForDisbursementRepository.count();}

    @GetMapping("/waiting")
    List<WaitingForDisbursement> getAllWaiting(){
        return waitingForDisbursementRepository.findAll();
    }
}
