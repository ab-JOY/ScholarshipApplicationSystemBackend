package com.SE102.ScholarshipApplicationSystem.controller;


import com.SE102.ScholarshipApplicationSystem.exception.ScholarNotFoundException;
import com.SE102.ScholarshipApplicationSystem.model.Scholar;
import com.SE102.ScholarshipApplicationSystem.repository.ScholarRepository;
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

    @GetMapping("/scholar")
    List<Scholar> getAllScholars(){
        return scholarRepository.findAll();
    }

    @GetMapping("/scholar/{id}")
    Scholar getScholarById(@PathVariable Long scholarId){
        return scholarRepository.findById(scholarId)
                .orElseThrow(()-> new ScholarNotFoundException(scholarId));
    }

    @PostMapping("/newscholar")
    Scholar newScholar(@RequestBody Scholar newScholar){
        return scholarRepository.save(newScholar);
    }

    @PutMapping("/scholar/{id}")
    Scholar updateScholar(@RequestBody Scholar newScholar, @PathVariable Long scholarId){
        return scholarRepository.findById(scholarId)
                .map(scholar -> {
                    scholar.setFullName(newScholar.getFullName());
                    scholar.setAge(newScholar.getAge());
                    scholar.setDateOfBirth(newScholar.getDateOfBirth());
                    scholar.setMunicipality(newScholar.getMunicipality());
                    scholar.setDetailedAddress(newScholar.getDetailedAddress());
                    scholar.setSchool(newScholar.getSchool());
                    scholar.setGWA(newScholar.getGWA());
                    scholar.setCourse(newScholar.getCourse());
                    scholar.setYearLevel(newScholar.getYearLevel());
                    scholar.setContactNumber(newScholar.getContactNumber());
                    scholar.setEmailAddress(newScholar.getEmailAddress());
                    scholar.setEmergencyContactPerson(newScholar.getEmergencyContactPerson());
                    scholar.setRelationshipWithEmergencyContact(newScholar.getRelationshipWithEmergencyContact());
                    scholar.setNameOfMother(newScholar.getNameOfMother());
                    scholar.setOccupationOfMother(newScholar.getOccupationOfMother());
                    scholar.setNameOfFather(newScholar.getNameOfFather());
                    scholar.setOccupationOfFather(newScholar.getOccupationOfFather());
                    scholar.setNumberOfSiblings(newScholar.getNumberOfSiblings());
                    scholar.setNumberOfSiblingsStudying(newScholar.getNumberOfSiblingsStudying());
                    scholar.setNumberOfSiblingsWorking(newScholar.getNumberOfSiblingsWorking());
                    scholar.setAnnualHouseholdIncome(newScholar.getAnnualHouseholdIncome());

                    return scholarRepository.save(scholar);
                }).orElseThrow(()-> new ScholarNotFoundException(scholarId));
    }

    @DeleteMapping
    String deleteScholar(@PathVariable Long scholarId){
        if(!scholarRepository.existsById(scholarId)){
            throw  new ScholarNotFoundException(scholarId);
        }
        else{
            scholarRepository.deleteById(scholarId);
            return "Member deleted successfully";
        }
    }

    @Autowired
    private TransferDataService transferDataService;
    public ResponseEntity<?> transferPendingApplication(){
        try{
            transferDataService.transferData();
            return ResponseEntity.ok("Success");
        } catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error transferring data");

        }
    }
}
