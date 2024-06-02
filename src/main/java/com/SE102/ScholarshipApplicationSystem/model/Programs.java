package com.SE102.ScholarshipApplicationSystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Programs {
    @Id
    @GeneratedValue
    private Long programId;
    private String programTitle;
    private String programDescription;
    private String programDeadline;
    private String programEligibility;
    private String programStatus;
    private String imageFilename;

    public Long getProgramId() {
        return programId;
    }

    public String getProgramTitle() {
        return programTitle;
    }

    public String getProgramDescription() {
        return programDescription;
    }

    public String getProgramDeadline() {
        return programDeadline;
    }

    public String getProgramEligibility() {
        return programEligibility;
    }

    public String getProgramStatus() {
        return programStatus;
    }

    public String getImageFilename() {
        return imageFilename;
    }

    public void setProgramId(Long programId) {
        this.programId = programId;
    }

    public void setProgramTitle(String programTitle) {
        this.programTitle = programTitle;
    }

    public void setProgramDescription(String programDescription) {
        this.programDescription = programDescription;
    }

    public void setProgramDeadline(String programDeadline) {
        this.programDeadline = programDeadline;
    }

    public void setProgramEligibility(String programEligibility) {
        this.programEligibility = programEligibility;
    }

    public void setProgramStatus(String programStatus) {
        this.programStatus = programStatus;
    }

    public void setImageFilename(String imageFilename) {
        this.imageFilename = imageFilename;
    }
}
