package com.SE102.ScholarshipApplicationSystem.exception;

public class ProgramNotFoundException extends RuntimeException{

    public ProgramNotFoundException(Long programId){
        super("Could not found program with id: " + programId);
    }

}
