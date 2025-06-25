package com.proyCibertec.web.dto;

import lombok.Data;

@Data
public class UserRequestDto {
    private String nombre;
    private String email;
    private String contrasenia;
    private String rol;
}
