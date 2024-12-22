package com.gazi.lostFound.services;

import java.util.List;
import java.util.Optional;

import com.gazi.lostFound.User.UserRole;
import com.gazi.lostFound.dto.LoginUserDto;
import com.gazi.lostFound.dto.UserResponseDto;
import com.gazi.lostFound.dto.RegisterUserDto;
import com.gazi.lostFound.entities.AdminEntity;
import com.gazi.lostFound.entities.RegularUser;
import com.gazi.lostFound.entities.UserEntity;
import com.gazi.lostFound.exceptions.UserAlreadyExistsException;
import com.gazi.lostFound.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService implements AuthServieInterface {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder; // Injected bean to keep consistency with other parts of the app
    }

    public UserResponseDto register(RegisterUserDto dto) {
        Optional<UserEntity> existingUser = userRepository.findByEmail(dto.getEmail());
        if (existingUser.isPresent()) {

            throw new UserAlreadyExistsException("User with this email already exists.");
        }

        // Hash the password before saving it
        String encodedPassword = passwordEncoder.encode(dto.getPassword());
        UserEntity user = new RegularUser(dto.getUsername(), dto.getEmail(), encodedPassword);
        userRepository.save(user);

        return new UserResponseDto(user.getUsername(), user.getEmail(), user.getRole(), user.getRegistrationDate());
    }

    @Override
    public UserResponseDto login(LoginUserDto loginUserDto) {
        Optional<UserEntity> existingUser = userRepository.findByEmail(loginUserDto.getEmail());
        if (existingUser.isEmpty() ||
                !passwordEncoder.matches(loginUserDto.getPassword(), existingUser.get().getPassword())) {
            throw new IllegalArgumentException("Invalid Credentials");
        }

        UserEntity user = existingUser.get();
        return new UserResponseDto(user.getUsername(), user.getEmail(), user.getRole(), user.getRegistrationDate());
    }



    public List<UserEntity> getAll() {
        return userRepository.findAll();
    }



    //register for admin
    public UserResponseDto adminRegister(RegisterUserDto dto) {
        Optional<UserEntity> existingUser = userRepository.findByEmail(dto.getEmail());
        if (existingUser.isPresent()) {
            throw new UserAlreadyExistsException("User with this email already exists.");
        }



        // Hash the password before saving it
        String encodedPassword = passwordEncoder.encode(dto.getPassword());
        UserEntity user = new AdminEntity(dto.getUsername(), dto.getEmail(), encodedPassword);
        userRepository.save(user);

        return new UserResponseDto(user.getUsername(), user.getEmail(), user.getRole(), user.getRegistrationDate());

    }
}