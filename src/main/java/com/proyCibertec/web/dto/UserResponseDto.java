package com.proyCibertec.web.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponseDto {
    private Long id;
    private String nombre;
    private String email;
    private String contrasenia;
    private String rol;
}
