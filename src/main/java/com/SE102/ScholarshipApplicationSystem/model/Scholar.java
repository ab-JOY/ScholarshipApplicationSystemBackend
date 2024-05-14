package com.SE102.ScholarshipApplicationSystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;


@Entity
public class Scholar {

    @Id
    @GeneratedValue
    private Long scholarId;
    private String fullName;
    private String age;
    private String dateOfBirth;
    private String province;
    private String municipality;
    private String detailedAddress;
    private String school;
    private String degree;
    private String course;
    private String yearLevel;
    private String contactNumber;
    private String emailAddress;
    private String emergencyContactPerson;
    private String relationshipWithEmergencyContact;
    private String nameOfMother;
    private String occupationOfMother;
    private String nameOfFather;
    private String occupationOfFather;
    private String numberOfSiblings;
    private String numberOfSiblingsStudying;
    private String numberOfSiblingsWorking;
    private String annualHouseholdIncome;

    private String userName;
    private String passWord;

    public Long getScholarId() {
        return scholarId;
    }

    public String getFullName() {
        return fullName;
    }

    public String getAge() {
        return age;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getMunicipality() {
        return municipality;
    }

    public String getDetailedAddress() {
        return detailedAddress;
    }

    public String getSchool() {
        return school;
    }

    public String getDegree() {
        return degree;
    }

    public String getCourse() {
        return course;
    }

    public String getYearLevel() {
        return yearLevel;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getEmergencyContactPerson() {
        return emergencyContactPerson;
    }

    public String getRelationshipWithEmergencyContact() {
        return relationshipWithEmergencyContact;
    }

    public String getNameOfMother() {
        return nameOfMother;
    }

    public String getOccupationOfMother() {
        return occupationOfMother;
    }

    public String getNameOfFather() {
        return nameOfFather;
    }

    public String getOccupationOfFather() {
        return occupationOfFather;
    }

    public String getNumberOfSiblings() {
        return numberOfSiblings;
    }

    public String getNumberOfSiblingsStudying() {
        return numberOfSiblingsStudying;
    }

    public String getNumberOfSiblingsWorking() {
        return numberOfSiblingsWorking;
    }

    public String getAnnualHouseholdIncome() {
        return annualHouseholdIncome;
    }

    public String getProvince() {
        return province;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setScholarId(Long scholarId) {
        this.scholarId = scholarId;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setMunicipality(String municipality) {
        this.municipality = municipality;
    }

    public void setDetailedAddress(String detailedAddress) {
        this.detailedAddress = detailedAddress;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setYearLevel(String yearLevel) {
        this.yearLevel = yearLevel;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setEmergencyContactPerson(String emergencyContactPerson) {
        this.emergencyContactPerson = emergencyContactPerson;
    }

    public void setRelationshipWithEmergencyContact(String relationshipWithEmergencyContact) {
        this.relationshipWithEmergencyContact = relationshipWithEmergencyContact;
    }

    public void setNameOfMother(String nameOfMother) {
        this.nameOfMother = nameOfMother;
    }

    public void setOccupationOfMother(String occupationOfMother) {
        this.occupationOfMother = occupationOfMother;
    }

    public void setNameOfFather(String nameOfFather) {
        this.nameOfFather = nameOfFather;
    }

    public void setOccupationOfFather(String occupationOfFather) {
        this.occupationOfFather = occupationOfFather;
    }

    public void setNumberOfSiblings(String numberOfSiblings) {
        this.numberOfSiblings = numberOfSiblings;
    }

    public void setNumberOfSiblingsStudying(String numberOfSiblingsStudying) {
        this.numberOfSiblingsStudying = numberOfSiblingsStudying;
    }

    public void setNumberOfSiblingsWorking(String numberOfSiblingsWorking) {
        this.numberOfSiblingsWorking = numberOfSiblingsWorking;
    }

    public void setAnnualHouseholdIncome(String annualHouseholdIncome) {
        this.annualHouseholdIncome = annualHouseholdIncome;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}

