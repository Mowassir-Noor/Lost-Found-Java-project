package com.gazi.lostFound.services;


import com.gazi.lostFound.dto.LoginUserDto;
import com.gazi.lostFound.dto.RegisterUserDto;
import com.gazi.lostFound.dto.UserResponseDto;

public interface AuthServieInterface {

    UserResponseDto register(RegisterUserDto registerUserDto);

    UserResponseDto login(LoginUserDto loginUserDto);

}
