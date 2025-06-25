package com.proyCibertec.application.service;

import com.proyCibertec.web.dto.UserLoginResponseDto;
import com.proyCibertec.web.dto.UserRequestDto;
import com.proyCibertec.web.dto.UserResponseDto;

import java.util.List;

public interface UserService {
    UserResponseDto getById(Long id);
    UserResponseDto create(UserRequestDto dto);
    UserResponseDto update(Long id, UserRequestDto dto);
    void delete(Long id);
    List<UserResponseDto> getAll();
    UserLoginResponseDto login(String email, String contrasenia);

}
