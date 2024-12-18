package com.gazi.lostFound.entities;

import com.gazi.lostFound.User.UserRole;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@DiscriminatorValue("Admin")
@Entity
public class AdminEntity extends UserEntity {

    public AdminEntity(String username, String email, String password) {
        super(username, email, password, UserRole.ROLE_ADMIN);
    }

    public AdminEntity() {
    }

    @Override
    public void userAction() {
        System.out.println("Admin specific actions executed");
    }

}
