package com.gazi.lostFound.User;

import java.time.LocalDateTime;

public abstract class User {
    private String username;
    private String email;
    private String password;
    private UserRole role;
    private LocalDateTime registrationDate;

    public User(String username,String email, String password, UserRole role) {
        this.username =username;
        this.email = email;
        this.password = password;
        this.role=role;
        this.registrationDate = LocalDateTime.now();
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username=username;
    }

    public String getEmail() {
        return email;

    }
    public void setEmail(String email) {
        this.email=email;

    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password=password;
    }

    public UserRole getRole() {
        return role;

    }

    public void setRole(UserRole role) {
        this.role=role;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate=registrationDate;
    }

    public abstract  void userAction();


}
