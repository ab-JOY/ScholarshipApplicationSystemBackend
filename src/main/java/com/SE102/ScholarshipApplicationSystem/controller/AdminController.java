package com.SE102.ScholarshipApplicationSystem.controller;


import com.SE102.ScholarshipApplicationSystem.exception.AdminNotFoundException;
import com.SE102.ScholarshipApplicationSystem.model.Admin;
import com.SE102.ScholarshipApplicationSystem.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class AdminController {

    @Autowired
    private AdminRepository adminRepository;

    @GetMapping("/admin")
    List<Admin> getAllAdmin(){
        return adminRepository.findAll();    }

    @GetMapping("/admin/{adminId}")
    Admin getAdminById(@PathVariable Long adminId){
        return adminRepository.findById(adminId)
                .orElseThrow(()-> new AdminNotFoundException(adminId));
    }
    @PutMapping("/admin/{adminId}")
    Admin updateAdmin(@RequestBody Admin newAdmin, @PathVariable Long adminId){
        return adminRepository.findById(adminId)
                .map(admin -> {
                    admin.setEmail(newAdmin.getEmail());
                    admin.setAdminFullName(newAdmin.getAdminFullName());
                    admin.setAdminPassword(newAdmin.getAdminPassword());
                    admin.setAdminPosition(newAdmin.getAdminPosition());
                return adminRepository.save(admin);
                }).orElseThrow(()-> new AdminNotFoundException(adminId));
    }

    @DeleteMapping("/admin/{adminId}")
    String deleteAdmin(@PathVariable Long adminId){
        if(!adminRepository.existsById(adminId)){
            throw new AdminNotFoundException(adminId);
        }
        else{
            adminRepository.deleteById(adminId);
            return "Deleted Successfully";
        }
    }
}
