package com.SE102.ScholarshipApplicationSystem.service;

import com.SE102.ScholarshipApplicationSystem.model.*;
import com.SE102.ScholarshipApplicationSystem.repository.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TransferDataService {

    @Autowired
    private ScholarRepository scholarRepository;

    @Autowired
    private ScholarPendingRepository scholarPendingRepository;

    @Autowired
    private ProgramsRepository programsRepository;

    @Autowired
    private WaitingForDisbursementRepository waitingForDisbursementRepository;

    @Autowired
    private DisbursedScholarshipRepository disbursedScholarshipRepository;

    @Transactional
    public void transferData(){
        List<ScholarPending> scholarPendingData = scholarPendingRepository.findAll();

        scholarPendingRepository.deleteAll();

        List<Scholar> newTableData = scholarPendingData.stream()
                .map(scholarPending -> {
                Scholar scholar = new Scholar();
                scholar.setFullName(scholarPending.getFullName_pending());
                scholar.setNumberOfSiblingsWorking(scholarPending.getNumberOfSiblingsWorking_pending());
                scholar.setNumberOfSiblings(scholarPending.getNumberOfSiblings_pending());
                scholar.setAnnualHouseholdIncome(scholarPending.getAnnualHouseholdIncome_pending());
                scholar.setNameOfFather(scholarPending.getNameOfFather_pending());
                scholar.setOccupationOfFather(scholarPending.getOccupationOfFather_pending());
                scholar.setNameOfMother(scholarPending.getNameOfMother_pending());
                scholar.setOccupationOfMother(scholarPending.getOccupationOfMother_pending());
                scholar.setGWA(scholarPending.getGwa_pending());
                scholar.setRelationshipWithEmergencyContact(scholarPending.getRelationshipWithEmergencyContact_pending());
                scholar.setEmergencyContactPerson(scholarPending.getEmergencyContactPerson_pending());
                scholar.setNumberOfSiblingsStudying(scholarPending.getNumberOfSiblingsStudying_pending());
                scholar.setEmailAddress(scholarPending.getEmailAddress_pending());
                scholar.setContactNumber(scholarPending.getContactNumber_pending());
                scholar.setYearLevel(scholarPending.getYearLevel_pending());
                scholar.setCourse(scholarPending.getCourse_pending());
                scholar.setSchool(scholarPending.getSchool_pending());
                scholar.setDetailedAddress(scholarPending.getDetailedAddress_pending());
                scholar.setMunicipality(scholarPending.getMunicipality_pending());
                scholar.setDateOfBirth(scholarPending.getDateOfBirth_pending());
                scholar.setAge(scholarPending.getAge_pending());
                return scholar;
                })
                .collect(Collectors.toList());
        scholarRepository.saveAll(newTableData);
    }

    @Transactional
    public void transferSingleRecord(Long pendingId){
        Optional<ScholarPending> scholarPendingOptional = scholarPendingRepository.findById(pendingId);

        scholarPendingOptional.ifPresent(scholarPending -> {
            Scholar scholar = new Scholar();
            scholar.setFullName(scholarPending.getFullName_pending());
            scholar.setNumberOfSiblingsWorking(scholarPending.getNumberOfSiblingsWorking_pending());
            scholar.setNumberOfSiblings(scholarPending.getNumberOfSiblings_pending());
            scholar.setAnnualHouseholdIncome(scholarPending.getAnnualHouseholdIncome_pending());
            scholar.setNameOfFather(scholarPending.getNameOfFather_pending());
            scholar.setOccupationOfFather(scholarPending.getOccupationOfFather_pending());
            scholar.setNameOfMother(scholarPending.getNameOfMother_pending());
            scholar.setOccupationOfMother(scholarPending.getOccupationOfMother_pending());
            scholar.setGWA(scholarPending.getGwa_pending());
            scholar.setRelationshipWithEmergencyContact(scholarPending.getRelationshipWithEmergencyContact_pending());
            scholar.setEmergencyContactPerson(scholarPending.getEmergencyContactPerson_pending());
            scholar.setNumberOfSiblingsStudying(scholarPending.getNumberOfSiblingsStudying_pending());
            scholar.setEmailAddress(scholarPending.getEmailAddress_pending());
            scholar.setContactNumber(scholarPending.getContactNumber_pending());
            scholar.setYearLevel(scholarPending.getYearLevel_pending());
            scholar.setCourse(scholarPending.getCourse_pending());
            scholar.setSchool(scholarPending.getSchool_pending());
            scholar.setDetailedAddress(scholarPending.getDetailedAddress_pending());
            scholar.setMunicipality(scholarPending.getMunicipality_pending());
            scholar.setDateOfBirth(scholarPending.getDateOfBirth_pending());
            scholar.setAge(scholarPending.getAge_pending());
            scholarRepository.save(scholar);

            scholarPendingRepository.deleteById(pendingId);
        });
    }

    @Transactional
    public void waitingStatus(Long programId){
        Optional<Programs> programsOptional = programsRepository.findById(programId);

        programsOptional.ifPresent(programs -> {
            WaitingForDisbursement waitingForDisbursement = new WaitingForDisbursement();
            waitingForDisbursement.setProgramId_waiting(programs.getProgramId());
            waitingForDisbursement.setProgramTitle_waiting(programs.getProgramTitle());
            waitingForDisbursement.setProgramDescription_waiting(programs.getProgramDescription());
            waitingForDisbursement.setProgramEligibility_waiting(programs.getProgramEligibility());
            waitingForDisbursement.setProgramDeadline_waiting(programs.getProgramDeadline());
            waitingForDisbursement.setProgramStatus_waiting("Waiting for Disbursement");
            waitingForDisbursement.setImageFilename_waiting(programs.getImageFilename());

            waitingForDisbursementRepository.save(waitingForDisbursement);

            programsRepository.deleteById(programId);
        });
    }

    @Transactional
    public void disbursedStatus(Long programId_waiting){
        Optional<WaitingForDisbursement> waitingForDisbursementOptional = waitingForDisbursementRepository.findById(programId_waiting);

        waitingForDisbursementOptional.ifPresent(waitingForDisbursement -> {
            DisbursedScholarship disbursedScholarship = new DisbursedScholarship();
            disbursedScholarship.setProgramId_disbursed(waitingForDisbursement.getProgramId_waiting());
            disbursedScholarship.setProgramTitle_disbursed(waitingForDisbursement.getProgramTitle_waiting());
            disbursedScholarship.setProgramDescription_disbursed(waitingForDisbursement.getProgramDescription_waiting());
            disbursedScholarship.setProgramEligibility_disbursed(waitingForDisbursement.getProgramEligibility_waiting());
            disbursedScholarship.setProgramDeadline_disbursed(waitingForDisbursement.getProgramDeadline_waiting());
            disbursedScholarship.setProgramStatus_disbursed("Disbursed");
            disbursedScholarship.setImageFilename_disbursed(waitingForDisbursement.getImageFilename_waiting());
            disbursedScholarshipRepository.save(disbursedScholarship);

            waitingForDisbursementRepository.deleteById(programId_waiting);
        });
    }

    @Transactional
    public void listProgram(Long programId_disbursed){
        Optional<DisbursedScholarship> disbursedScholarshipOptional = disbursedScholarshipRepository.findById(programId_disbursed);

        disbursedScholarshipOptional.ifPresent(disbursedScholarship -> {
            Programs programs = new Programs();
            programs.setProgramTitle(disbursedScholarship.getProgramTitle_disbursed());
            programs.setProgramDescription(disbursedScholarship.getProgramDescription_disbursed());
            programs.setProgramEligibility(disbursedScholarship.getProgramEligibility_disbursed());
            programs.setProgramDeadline(disbursedScholarship.getProgramDeadline_disbursed());
            programs.setProgramStatus("On-going");
            programs.setImageFilename(disbursedScholarship.getImageFilename_disbursed());

            programsRepository.save(programs);

            disbursedScholarshipRepository.deleteById(programId_disbursed);

        });
    }
}
