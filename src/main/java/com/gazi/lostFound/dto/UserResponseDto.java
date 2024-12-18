package com.gazi.lostFound.dto;

import com.gazi.lostFound.User.UserRole;

import java.time.LocalDateTime;

public class UserResponseDto {

    private String username;
    private String email;
    private UserRole role;
    private LocalDateTime registrationDate;

    public UserResponseDto(String username, String email,UserRole role, LocalDateTime registrationDate) {
        this.username = username;
        this.email = email;
        this.role = UserRole.valueOf(role.name());
        this.registrationDate = registrationDate;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public UserRole getRole() {
        return role;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }
}
