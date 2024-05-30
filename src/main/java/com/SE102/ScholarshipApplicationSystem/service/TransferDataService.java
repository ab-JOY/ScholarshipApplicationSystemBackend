package com.SE102.ScholarshipApplicationSystem.service;

import com.SE102.ScholarshipApplicationSystem.model.Scholar;
import com.SE102.ScholarshipApplicationSystem.model.ScholarPending;
import com.SE102.ScholarshipApplicationSystem.repository.ScholarPendingRepository;
import com.SE102.ScholarshipApplicationSystem.repository.ScholarRepository;
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
                scholar.setPassWord(scholarPending.getPassword_pending());
                scholar.setUserName(scholarPending.getUserName_pending());
                scholar.setScholarId(scholarPending.getPendingId());

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
            scholar.setUserName(scholarPending.getUserName_pending());
            scholar.setScholarId(scholarPending.getPendingId());

            scholarRepository.save(scholar);

            scholarPendingRepository.deleteById(pendingId);
        });
    }
}
