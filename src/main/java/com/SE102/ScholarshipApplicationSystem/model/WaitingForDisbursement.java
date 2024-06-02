package com.SE102.ScholarshipApplicationSystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class WaitingForDisbursement {

    @Id
    private Long programId_waiting;
    private String programTitle_waiting;
    private String programDescription_waiting;
    private String programDeadline_waiting;
    private String programEligibility_waiting;
    private String programStatus_waiting;
    private String imageFilename_waiting;

    public String getProgramStatus_waiting() {
        return programStatus_waiting;
    }

    public void setProgramStatus_waiting(String programStatus_waiting) {
        this.programStatus_waiting = programStatus_waiting;
    }

    public String getImageFilename_waiting() {
        return imageFilename_waiting;
    }

    public void setImageFilename_waiting(String imageFilename_waiting) {
        this.imageFilename_waiting = imageFilename_waiting;
    }

    public Long getProgramId_waiting() {
        return programId_waiting;
    }

    public String getProgramTitle_waiting() {
        return programTitle_waiting;
    }

    public String getProgramDescription_waiting() {
        return programDescription_waiting;
    }

    public String getProgramDeadline_waiting() {
        return programDeadline_waiting;
    }

    public String getProgramEligibility_waiting() {
        return programEligibility_waiting;
    }

    public void setProgramId_waiting(Long programId_waiting) {
        this.programId_waiting = programId_waiting;
    }

    public void setProgramTitle_waiting(String programTitle_waiting) {
        this.programTitle_waiting = programTitle_waiting;
    }

    public void setProgramDescription_waiting(String programDescription_waiting) {
        this.programDescription_waiting = programDescription_waiting;
    }

    public void setProgramDeadline_waiting(String programDeadline_waiting) {
        this.programDeadline_waiting = programDeadline_waiting;
    }

    public void setProgramEligibility_waiting(String programEligibility_waiting) {
        this.programEligibility_waiting = programEligibility_waiting;
    }
}
