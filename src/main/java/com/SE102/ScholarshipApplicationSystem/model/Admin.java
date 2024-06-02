package com.SE102.ScholarshipApplicationSystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;


@Data
@Entity
public class Admin implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long adminId;
    private String email;
    private String adminPassword;
    private String adminFullName;
    private String adminPosition;
    private String privilege;

    public Long getAdminId() {
        return adminId;
    }

    public String getEmail() {
        return email;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public String getAdminFullName() {
        return adminFullName;
    }

    public String getAdminPosition() {
        return adminPosition;
    }

    public String getPrivilege() {
        return privilege;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    public void setAdminFullName(String adminFullName) {
        this.adminFullName = adminFullName;
    }

    public void setAdminPosition(String adminPosition) {
        this.adminPosition = adminPosition;
    }

    public void setPrivilege(String privilege) {
        this.privilege = privilege;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(privilege));
    }

    @Override
    public String getPassword() {
        return adminPassword;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


}
