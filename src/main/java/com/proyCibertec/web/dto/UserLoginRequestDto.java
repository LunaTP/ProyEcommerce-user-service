package com.proyCibertec.web.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class UserLoginRequestDto {
    private String email;
    private String contrasenia;
}
