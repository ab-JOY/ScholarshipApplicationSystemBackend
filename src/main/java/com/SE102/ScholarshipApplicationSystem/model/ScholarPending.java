package com.SE102.ScholarshipApplicationSystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class ScholarPending {
    @Id
    @GeneratedValue
    private Long pendingId;
    private String fullName_pending;
    private String age_pending;
    private String dateOfBirth_pending;
    private String municipality_pending;
    private String detailedAddress_pending;
    private String school_pending;
    private String gwa_pending;
    private String course_pending;
    private String yearLevel_pending;
    private String contactNumber_pending;
    private String emailAddress_pending;
    private String emergencyContactPerson_pending;
    private String relationshipWithEmergencyContact_pending;
    private String nameOfMother_pending;
    private String occupationOfMother_pending;
    private String nameOfFather_pending;
    private String occupationOfFather_pending;
    private String numberOfSiblings_pending;
    private String numberOfSiblingsStudying_pending;
    private String numberOfSiblingsWorking_pending;
    private String annualHouseholdIncome_pending;
    private String userName_pending;
    private String password_pending;

    public Long getPendingId() {
        return pendingId;
    }

    public String getFullName_pending() {
        return fullName_pending;
    }

    public String getAge_pending() {
        return age_pending;
    }

    public String getDateOfBirth_pending() {
        return dateOfBirth_pending;
    }

    public String getMunicipality_pending() {
        return municipality_pending;
    }

    public String getDetailedAddress_pending() {
        return detailedAddress_pending;
    }

    public String getSchool_pending() {
        return school_pending;
    }

    public String getGwa_pending() {
        return gwa_pending;
    }

    public String getCourse_pending() {
        return course_pending;
    }

    public String getYearLevel_pending() {
        return yearLevel_pending;
    }

    public String getContactNumber_pending() {
        return contactNumber_pending;
    }

    public String getEmailAddress_pending() {
        return emailAddress_pending;
    }

    public String getEmergencyContactPerson_pending() {
        return emergencyContactPerson_pending;
    }

    public String getRelationshipWithEmergencyContact_pending() {
        return relationshipWithEmergencyContact_pending;
    }

    public String getNameOfMother_pending() {
        return nameOfMother_pending;
    }

    public String getOccupationOfMother_pending() {
        return occupationOfMother_pending;
    }

    public String getNameOfFather_pending() {
        return nameOfFather_pending;
    }

    public String getOccupationOfFather_pending() {
        return occupationOfFather_pending;
    }

    public String getNumberOfSiblings_pending() {
        return numberOfSiblings_pending;
    }

    public String getNumberOfSiblingsStudying_pending() {
        return numberOfSiblingsStudying_pending;
    }

    public String getNumberOfSiblingsWorking_pending() {
        return numberOfSiblingsWorking_pending;
    }

    public String getAnnualHouseholdIncome_pending() {
        return annualHouseholdIncome_pending;
    }

    public String getUserName_pending() {
        return userName_pending;
    }

    public String getPassword_pending() {
        return password_pending;
    }

    public void setPendingId(Long pendingId) {
        this.pendingId = pendingId;
    }

    public void setFullName_pending(String fullName_pending) {
        this.fullName_pending = fullName_pending;
    }

    public void setAge_pending(String age_pending) {
        this.age_pending = age_pending;
    }

    public void setDateOfBirth_pending(String dateOfBirth_pending) {
        this.dateOfBirth_pending = dateOfBirth_pending;
    }

    public void setMunicipality_pending(String municipality_pending) {
        this.municipality_pending = municipality_pending;
    }

    public void setDetailedAddress_pending(String detailedAddress_pending) {
        this.detailedAddress_pending = detailedAddress_pending;
    }

    public void setSchool_pending(String school_pending) {
        this.school_pending = school_pending;
    }

    public void setGwa_pending(String gwa_pending) {
        this.gwa_pending = gwa_pending;
    }

    public void setCourse_pending(String course_pending) {
        this.course_pending = course_pending;
    }

    public void setYearLevel_pending(String yearLevel_pending) {
        this.yearLevel_pending = yearLevel_pending;
    }

    public void setContactNumber_pending(String contactNumber_pending) {
        this.contactNumber_pending = contactNumber_pending;
    }

    public void setEmailAddress_pending(String emailAddress_pending) {
        this.emailAddress_pending = emailAddress_pending;
    }

    public void setEmergencyContactPerson_pending(String emergencyContactPerson_pending) {
        this.emergencyContactPerson_pending = emergencyContactPerson_pending;
    }

    public void setRelationshipWithEmergencyContact_pending(String relationshipWithEmergencyContact_pending) {
        this.relationshipWithEmergencyContact_pending = relationshipWithEmergencyContact_pending;
    }

    public void setNameOfMother_pending(String nameOfMother_pending) {
        this.nameOfMother_pending = nameOfMother_pending;
    }

    public void setOccupationOfMother_pending(String occupationOfMother_pending) {
        this.occupationOfMother_pending = occupationOfMother_pending;
    }

    public void setNameOfFather_pending(String nameOfFather_pending) {
        this.nameOfFather_pending = nameOfFather_pending;
    }

    public void setOccupationOfFather_pending(String occupationOfFather_pending) {
        this.occupationOfFather_pending = occupationOfFather_pending;
    }

    public void setNumberOfSiblings_pending(String numberOfSiblings_pending) {
        this.numberOfSiblings_pending = numberOfSiblings_pending;
    }

    public void setNumberOfSiblingsStudying_pending(String numberOfSiblingsStudying_pending) {
        this.numberOfSiblingsStudying_pending = numberOfSiblingsStudying_pending;
    }

    public void setNumberOfSiblingsWorking_pending(String numberOfSiblingsWorking_pending) {
        this.numberOfSiblingsWorking_pending = numberOfSiblingsWorking_pending;
    }

    public void setAnnualHouseholdIncome_pending(String annualHouseholdIncome_pending) {
        this.annualHouseholdIncome_pending = annualHouseholdIncome_pending;
    }

    public void setUserName_pending(String userName_pending) {
        this.userName_pending = userName_pending;
    }

    public void setPassword_pending(String password_pending) {
        this.password_pending = password_pending;
    }
}
