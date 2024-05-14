package com.SE102.ScholarshipApplicationSystem.exception;

public class ScholarPendingNotFoundException extends RuntimeException{

    public ScholarPendingNotFoundException(Long pendingId){
        super("Could not found member with id: " + pendingId);
    }
}
