package com.SE102.ScholarshipApplicationSystem.service;

import com.SE102.ScholarshipApplicationSystem.dto.RequestResponse;
import com.SE102.ScholarshipApplicationSystem.model.Admin;
import com.SE102.ScholarshipApplicationSystem.model.Scholar;
import com.SE102.ScholarshipApplicationSystem.repository.AdminRepository;
import com.SE102.ScholarshipApplicationSystem.repository.ScholarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class AuthService {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private ScholarRepository scholarRepository;

    @Autowired
    private JWTUtils jwtUtils;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    public RequestResponse signUp(RequestResponse registrationRequest) {
        RequestResponse response = new RequestResponse();
        try {
            Admin admin = new Admin();
            admin.setEmail(registrationRequest.getEmail());
            admin.setAdminPassword(passwordEncoder.encode(registrationRequest.getPassword()));
            admin.setAdminFullName(registrationRequest.getAdminFullName());
            admin.setPrivilege(registrationRequest.getPrivilege());
            admin.setAdminPosition(registrationRequest.getPosition());
            Admin adminResult = adminRepository.save(admin);
            if (adminResult != null && adminResult.getAdminId() > 0) {
                response.setAdmin(adminResult);
                response.setMessage("saved");
                response.setStatusCode(200);
            }
        } catch (Exception e) {
            response.setStatusCode(500);
            response.setError(e.getMessage());
        }
        return response;
    }

    public RequestResponse signIn(RequestResponse signInRequest) {
        RequestResponse response1 = new RequestResponse();
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(signInRequest.getEmail(), signInRequest.getPassword()));
            var admin = adminRepository.findByEmail(signInRequest.getEmail()).orElseThrow();
            System.out.println("USER IS: " + admin);
            var jwt = jwtUtils.generateToken(admin);
            var refreshToken = jwtUtils.generateRefreshToken(new HashMap<>(), admin);
            response1.setPrivilege(admin.getPrivilege());
            response1.setStatusCode(200);
            response1.setToken(jwt);
            response1.setRefreshToken(refreshToken);
            response1.setExpirationTime("24H");
            response1.setMessage("signin success");
        } catch (Exception e) {
            response1.setStatusCode(500);
            response1.setError(e.getMessage());
        }
        return response1;
    }


    public RequestResponse refreshToken(RequestResponse refreshTokenRequest) {
        RequestResponse response = new RequestResponse();
        String adminEmail = jwtUtils.extractUsername(refreshTokenRequest.getRefreshToken());
        Admin admin = adminRepository.findByEmail(adminEmail).orElseThrow();
        if (jwtUtils.isTokenValid(refreshTokenRequest.getToken(), admin)) {
            var jwt = jwtUtils.generateToken(admin);
            response.setPrivilege(admin.getPrivilege());
            response.setToken(jwt);
            response.setRefreshToken(refreshTokenRequest.getToken());
            response.setExpirationTime("24H");
            response.setMessage("Successfully Refresh Token");
        }

        response.setStatusCode(500);
        return response;
    }

}



