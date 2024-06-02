package com.SE102.ScholarshipApplicationSystem.service;


import com.SE102.ScholarshipApplicationSystem.exception.ScholarPendingNotFoundException;
import com.SE102.ScholarshipApplicationSystem.model.ScholarPending;
import com.SE102.ScholarshipApplicationSystem.repository.ScholarPendingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScholarPendingService {

    @Autowired
    private ScholarPendingRepository scholarPendingRepository;

    public long getPendingCount(){
       return scholarPendingRepository.count();
    }

    public ScholarPending updateScholarPending(Long pendingId, ScholarPending newScholarPending) {
        return scholarPendingRepository.findById(pendingId)
                .map(scholarPending -> {
                    scholarPending.setFullName_pending(newScholarPending.getFullName_pending());
                    scholarPending.setAge_pending(newScholarPending.getAge_pending());
                    scholarPending.setDateOfBirth_pending(newScholarPending.getDateOfBirth_pending());
                    scholarPending.setMunicipality_pending(newScholarPending.getMunicipality_pending());
                    scholarPending.setDetailedAddress_pending(newScholarPending.getDetailedAddress_pending());
                    scholarPending.setSchool_pending(newScholarPending.getSchool_pending());
                    scholarPending.setGwa_pending(newScholarPending.getGwa_pending());
                    scholarPending.setCourse_pending(newScholarPending.getCourse_pending());
                    scholarPending.setYearLevel_pending(newScholarPending.getYearLevel_pending());
                    scholarPending.setContactNumber_pending(newScholarPending.getContactNumber_pending());
                    scholarPending.setEmailAddress_pending(newScholarPending.getEmailAddress_pending());
                    scholarPending.setEmergencyContactPerson_pending(newScholarPending.getEmergencyContactPerson_pending());
                    scholarPending.setRelationshipWithEmergencyContact_pending(newScholarPending.getRelationshipWithEmergencyContact_pending());
                    scholarPending.setNameOfMother_pending(newScholarPending.getNameOfMother_pending());
                    scholarPending.setOccupationOfMother_pending(newScholarPending.getOccupationOfMother_pending());
                    scholarPending.setNameOfFather_pending(newScholarPending.getNameOfFather_pending());
                    scholarPending.setOccupationOfFather_pending(newScholarPending.getOccupationOfFather_pending());
                    scholarPending.setNumberOfSiblings_pending(newScholarPending.getNumberOfSiblings_pending());
                    scholarPending.setNumberOfSiblingsStudying_pending(newScholarPending.getNumberOfSiblingsStudying_pending());
                    scholarPending.setNumberOfSiblingsWorking_pending(newScholarPending.getNumberOfSiblingsWorking_pending());
                    scholarPending.setAnnualHouseholdIncome_pending(newScholarPending.getAnnualHouseholdIncome_pending());

                    return scholarPendingRepository.save(scholarPending);
                }).orElseThrow(() -> new ScholarPendingNotFoundException(pendingId));
    }

}
