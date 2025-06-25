package com.proyCibertec.application.mapper;

import com.proyCibertec.domain.model.RolUser;
import com.proyCibertec.domain.model.User;
import com.proyCibertec.web.dto.UserRequestDto;
import com.proyCibertec.web.dto.UserResponseDto;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User toEntity(UserRequestDto dto) {
        return User.builder()
                .nombre(dto.getNombre())
                .email(dto.getEmail())
                .contrasenia(dto.getContrasenia())
                .rol(RolUser.valueOf(dto.getRol())).build();
    }

    public UserResponseDto toResponseDto(User user){
        return UserResponseDto.builder()
                .id(user.getId())
                .nombre(user.getNombre())
                .email(user.getEmail())
                .contrasenia(user.getContrasenia())
                .rol(user.getRol().name())
                .build();
    }

}
