package com.SE102.ScholarshipApplicationSystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class DisbursedScholarship {

    @Id
    private Long programId_disbursed;
    private String programTitle_disbursed;
    private String programDescription_disbursed;
    private String programDeadline_disbursed;
    private String programEligibility_disbursed;
    private String programStatus_disbursed;
    private String imageFilename_disbursed;

    public String getImageFilename_disbursed() {
        return imageFilename_disbursed;
    }

    public void setImageFilename_disbursed(String imageFilename_disbursed) {
        this.imageFilename_disbursed = imageFilename_disbursed;
    }

    public Long getProgramId_disbursed() {
        return programId_disbursed;
    }

    public void setProgramId_disbursed(Long programId_disbursed) {
        this.programId_disbursed = programId_disbursed;
    }

    public String getProgramTitle_disbursed() {
        return programTitle_disbursed;
    }

    public void setProgramTitle_disbursed(String programTitle_disbursed) {
        this.programTitle_disbursed = programTitle_disbursed;
    }

    public String getProgramDescription_disbursed() {
        return programDescription_disbursed;
    }

    public void setProgramDescription_disbursed(String programDescription_disbursed) {
        this.programDescription_disbursed = programDescription_disbursed;
    }

    public String getProgramDeadline_disbursed() {
        return programDeadline_disbursed;
    }

    public void setProgramDeadline_disbursed(String programDeadline_disbursed) {
        this.programDeadline_disbursed = programDeadline_disbursed;
    }

    public String getProgramEligibility_disbursed() {
        return programEligibility_disbursed;
    }

    public void setProgramEligibility_disbursed(String programEligibility_disbursed) {
        this.programEligibility_disbursed = programEligibility_disbursed;
    }

    public String getProgramStatus_disbursed() {
        return programStatus_disbursed;
    }

    public void setProgramStatus_disbursed(String programStatus_disbursed) {
        this.programStatus_disbursed = programStatus_disbursed;
    }
}
