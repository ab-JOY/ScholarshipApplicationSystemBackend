package com.SE102.ScholarshipApplicationSystem.exception;

public class AdminNotFoundException extends RuntimeException{
    public AdminNotFoundException(Long adminId){
        super("Account does not exist" + adminId);
    }
}
