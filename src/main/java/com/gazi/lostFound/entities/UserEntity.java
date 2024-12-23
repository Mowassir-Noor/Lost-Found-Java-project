package com.gazi.lostFound.entities;
import com.gazi.lostFound.User.UserRole;
import jakarta.persistence.*;
import java.time.LocalDateTime;

//abstract userEntity for security and connection with database and
// this class has been inherited by AdminEntity and RegularUser
@Entity
@Table(name = "Users")
public abstract class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name="role" ,nullable = false)
    private UserRole role;

    @Column(name = "registration_date", nullable = false)
    private LocalDateTime registrationDate;

    // Parameterized constructor
    public UserEntity(String username, String email, String password, UserRole role) {
        setUsername(username);
        setEmail(email);
        setPassword(password);
        this.role = role;
        this.registrationDate = LocalDateTime.now();
    }
    // Default constructor for JPA
    public UserEntity() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        if (username == null || username.trim().isEmpty()) {
            throw new IllegalArgumentException("Username cannot be null or empty");
        }
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("Invalid email address");
        }
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (password == null || password.length() < 6) {
            throw new IllegalArgumentException("Password must be at least 6 characters long");
        }
        this.password = password;
    }


    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }

    // Abstract method for specific user actions
    public abstract void userAction();
}
