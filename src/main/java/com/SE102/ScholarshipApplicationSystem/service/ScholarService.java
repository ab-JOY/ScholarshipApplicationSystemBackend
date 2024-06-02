package com.SE102.ScholarshipApplicationSystem.service;

import com.SE102.ScholarshipApplicationSystem.exception.ScholarNotFoundException;
import com.SE102.ScholarshipApplicationSystem.model.Scholar;
import com.SE102.ScholarshipApplicationSystem.repository.ScholarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScholarService {

    @Autowired
    private ScholarRepository scholarRepository;

    public long getCount(){
        return scholarRepository.count();
    }

    public Scholar updateScholar(Long scholarId, Scholar newScholar) {
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
                }).orElseThrow(() -> new ScholarNotFoundException(scholarId));
    }

}
