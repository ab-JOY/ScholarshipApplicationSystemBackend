package com.SE102.ScholarshipApplicationSystem.exception;


public class ScholarNotFoundException extends RuntimeException {
    public ScholarNotFoundException(Long scholarId){
         super("Scholar does not exist" + scholarId);
    }
}
