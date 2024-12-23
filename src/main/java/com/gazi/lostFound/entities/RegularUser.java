package com.gazi.lostFound.entities;

import com.gazi.lostFound.User.UserRole;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@DiscriminatorValue("RegularUser")
@Entity
public class RegularUser extends UserEntity {
//    RegularUser class inherits UserEntity

//   parameterized constructos
    public RegularUser(String username, String email, String password) {
        super(username, email, password, UserRole.ROLE_USER);
    }

    public RegularUser() {}

//    overriding inherited function
    @Override
    public void userAction(){
        System.out.println("End User specific Actions Only");
    }
}
