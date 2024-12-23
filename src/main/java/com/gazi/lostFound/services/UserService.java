package com.gazi.lostFound.services;
import com.gazi.lostFound.entities.UserEntity;
import com.gazi.lostFound.repositories.UserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements org.springframework.security.core.userdetails.UserDetailsService {

    private final UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

//load the user by username  email in this case
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByEmail(email)
//                throw exception if user not found
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));


        return User.builder()
                .username(userEntity.getUsername())
                .password(userEntity.getPassword())
                .roles(userEntity.getRole().toString()) // Assign roles (e.g., ROLE_ADMIN, ROLE_USER)
                .build();
    }
}
