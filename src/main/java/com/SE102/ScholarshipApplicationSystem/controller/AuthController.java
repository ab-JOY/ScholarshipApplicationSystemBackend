package com.SE102.ScholarshipApplicationSystem.controller;

import com.SE102.ScholarshipApplicationSystem.dto.RequestResponse;
import com.SE102.ScholarshipApplicationSystem.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:3000")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/admin/signup")
    public ResponseEntity<?> adminSignUp(@RequestBody RequestResponse registrationRequest) {
        RequestResponse response = authService.signUp(registrationRequest);
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }



    @PostMapping("/admin/signin")
    public ResponseEntity<?> adminSignIn(@RequestBody RequestResponse signInRequest) {
        RequestResponse response = authService.signIn(signInRequest);
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }


}
