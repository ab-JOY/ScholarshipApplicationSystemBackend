package com.SE102.ScholarshipApplicationSystem.controller;


import com.SE102.ScholarshipApplicationSystem.exception.ProgramNotFoundException;
import com.SE102.ScholarshipApplicationSystem.model.Programs;
import com.SE102.ScholarshipApplicationSystem.repository.ProgramsRepository;
import org.springframework.beans.factory.annotation.Autowired;

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
                    programs.setImageFilename(newProgram.getImageFilename());

                    return programsRepository.save(programs);
                }).orElseThrow(()-> new ProgramNotFoundException(programId));
    }
}
