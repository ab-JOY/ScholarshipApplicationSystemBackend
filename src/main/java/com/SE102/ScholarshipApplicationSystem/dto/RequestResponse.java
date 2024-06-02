package com.SE102.ScholarshipApplicationSystem.dto;


import com.SE102.ScholarshipApplicationSystem.model.Admin;
import com.SE102.ScholarshipApplicationSystem.model.Scholar;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RequestResponse {
    private String email;
    private String emailAddress;
    private String password;
    private String fullName;
    private String adminFullName;
    private String privilege;
    private String position;
    private int statusCode;
    private String message;
    private String error;
    private String token;
    private String refreshToken;
    private String expirationTime;
    private Admin admin;
    private Scholar scholar;
}
