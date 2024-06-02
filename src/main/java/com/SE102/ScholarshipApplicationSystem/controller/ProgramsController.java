package com.SE102.ScholarshipApplicationSystem.controller;


import com.SE102.ScholarshipApplicationSystem.exception.ProgramNotFoundException;
import com.SE102.ScholarshipApplicationSystem.model.Programs;
import com.SE102.ScholarshipApplicationSystem.repository.ProgramsRepository;
import com.SE102.ScholarshipApplicationSystem.service.TransferDataService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class ProgramsController {

    @Autowired
    private ProgramsRepository programsRepository;

    @GetMapping("/programs")
    List<Programs> getAllPrograms(){
        return programsRepository.findAll();
    }

    @GetMapping("/programs/{programId}")
    Programs getProgramById(@PathVariable Long programId){
        return programsRepository.findById(programId)
                .orElseThrow(()-> new ProgramNotFoundException(programId));
    }

    @PostMapping("/programs")
    Programs newProgram(@RequestBody Programs newProgram){
        return programsRepository.save(newProgram);
    }

    @PutMapping("/programs/{programId}")
    Programs updateProgram(@RequestBody Programs newProgram, @PathVariable Long programId){
        return programsRepository.findById(programId)
                .map(programs -> {
                    programs.setProgramTitle(newProgram.getProgramTitle());
                    programs.setProgramDescription(newProgram.getProgramDescription());
                    programs.setProgramEligibility(newProgram.getProgramEligibility());
                    programs.setProgramDeadline(newProgram.getProgramDeadline());
                    programs.setProgramStatus(newProgram.getProgramStatus());
                    programs.setImageFilename(newProgram.getImageFilename());

                    return programsRepository.save(programs);
                }).orElseThrow(()-> new ProgramNotFoundException(programId));
    }

    @GetMapping("/programs/count")
    public Long getProgramsCount(){return programsRepository.count();}

    @Autowired
    private TransferDataService transferDataService;

    @PostMapping("/listProgram/{programId_disbursed}")
    public ResponseEntity<?> listProgram(@PathVariable Long programId_disbursed) {
        transferDataService.listProgram(programId_disbursed);
        return ResponseEntity.ok("Success");
    }
}
