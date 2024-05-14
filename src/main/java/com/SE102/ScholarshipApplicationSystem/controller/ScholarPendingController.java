package com.SE102.ScholarshipApplicationSystem.controller;


import com.SE102.ScholarshipApplicationSystem.exception.ScholarPendingNotFoundException;
import com.SE102.ScholarshipApplicationSystem.model.ScholarPending;
import com.SE102.ScholarshipApplicationSystem.repository.ScholarPendingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
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


}
