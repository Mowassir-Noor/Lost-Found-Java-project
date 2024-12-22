package com.gazi.lostFound.controller;

import com.gazi.lostFound.dto.LoginUserDto;
import com.gazi.lostFound.dto.RegisterUserDto;
import com.gazi.lostFound.dto.UserResponseDto;
import com.gazi.lostFound.exceptions.InvalidCredentials;
import com.gazi.lostFound.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<UserResponseDto> register(@Valid @RequestBody RegisterUserDto dto){
        try {
            UserResponseDto response = authService.register(dto);

            return ResponseEntity.ok(response);

        } catch (Exception e) {
            System.out.println(e.getMessage());
           return ResponseEntity.badRequest().build();
        }

    }

    @PostMapping("/login")
    public ResponseEntity<UserResponseDto> login(@Valid @RequestBody LoginUserDto loginUserDto){
        try {
            UserResponseDto response = authService.login(loginUserDto);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();

        }
    }

}
