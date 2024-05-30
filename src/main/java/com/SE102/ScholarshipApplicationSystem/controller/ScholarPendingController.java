package com.SE102.ScholarshipApplicationSystem.controller;


import com.SE102.ScholarshipApplicationSystem.exception.ScholarPendingNotFoundException;
import com.SE102.ScholarshipApplicationSystem.model.ScholarPending;
import com.SE102.ScholarshipApplicationSystem.repository.ScholarPendingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class ScholarPendingController {

    @Autowired
    private ScholarPendingRepository scholarPendingRepository;

    @PostMapping("/pendingApplication")
    ScholarPending newScholarPending(@RequestBody ScholarPending newScholarPending){
        return scholarPendingRepository.save(newScholarPending);
    }

    @GetMapping("/pendingApplication")
    List<ScholarPending> getAllScholarPending(){
        return scholarPendingRepository.findAll();
    }

    @GetMapping("/pendingApplication/{pendingId}")
    ScholarPending getScholarPendingById(@PathVariable Long pendingId){
        return scholarPendingRepository.findById(pendingId)
                .orElseThrow(()-> new ScholarPendingNotFoundException(pendingId));
    }

    @DeleteMapping("/pendingApplication/{pendingId}")
    String deletePendingApplication(@PathVariable Long pendingId){
        if(!scholarPendingRepository.existsById(pendingId)){
            throw new ScholarPendingNotFoundException(pendingId);
        }

        scholarPendingRepository.deleteById(pendingId);
        return "Member with id: " +pendingId+ "has been deleted successfully";
    }


}
