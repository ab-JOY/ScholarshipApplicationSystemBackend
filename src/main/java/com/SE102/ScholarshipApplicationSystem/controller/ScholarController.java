package com.SE102.ScholarshipApplicationSystem.controller;


import com.SE102.ScholarshipApplicationSystem.exception.ScholarNotFoundException;
import com.SE102.ScholarshipApplicationSystem.model.Scholar;
import com.SE102.ScholarshipApplicationSystem.repository.ScholarRepository;
import com.SE102.ScholarshipApplicationSystem.service.ScholarService;
import com.SE102.ScholarshipApplicationSystem.service.TransferDataService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class ScholarController {

    @Autowired
    private ScholarRepository scholarRepository;

    @Autowired
    private ScholarService scholarService;

    @GetMapping("/scholar")
    List<Scholar> getAllScholars(){
        return scholarRepository.findAll();
    }

    @GetMapping("/scholar/{scholarId}")
    Scholar getScholarById(@PathVariable Long scholarId){
        return scholarRepository.findById(scholarId)
                .orElseThrow(()-> new ScholarNotFoundException(scholarId));
    }

    @PostMapping("/newscholar")
    Scholar newScholar(@RequestBody Scholar newScholar){
        return scholarRepository.save(newScholar);
    }

    @PutMapping("/scholar/{scholarId}")
    public Scholar updateScholar(@RequestBody Scholar newScholar, @PathVariable Long scholarId) {
        return scholarService.updateScholar(scholarId, newScholar);
    }

    @DeleteMapping("/scholar/{scholarId}")
    String deleteScholar(@PathVariable Long scholarId){
        if(!scholarRepository.existsById(scholarId)){
            throw  new ScholarNotFoundException(scholarId);
        }
        else{
            scholarRepository.deleteById(scholarId);
            return "Member deleted successfully";
        }
    }

    @GetMapping("/scholar/count")
    public long getCount(){
        return scholarService.getCount();
    }

    @Autowired
    private TransferDataService transferDataService;

    @PostMapping("/scholar")
    public ResponseEntity<?> transferPendingApplication(){
        try{
            transferDataService.transferData();
            return ResponseEntity.ok("Success");
        } catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error transferring data");

        }
    }

    @PostMapping("/singlepost/{pendingId}")
    public ResponseEntity<?> transferSingleMember(@PathVariable Long pendingId) {
        transferDataService.transferSingleRecord(pendingId);
        return ResponseEntity.ok("Success");
    }
}
