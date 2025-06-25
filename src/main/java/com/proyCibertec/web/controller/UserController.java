package com.proyCibertec.web.controller;

import com.proyCibertec.application.service.UserService;
import com.proyCibertec.web.dto.UserLoginRequestDto;
import com.proyCibertec.web.dto.UserLoginResponseDto;
import com.proyCibertec.web.dto.UserRequestDto;
import com.proyCibertec.web.dto.UserResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/crear")
    public ResponseEntity<UserResponseDto> create(@RequestBody UserRequestDto dto) {
        UserResponseDto response = userService.create(dto);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<UserResponseDto> getById(@PathVariable Long id) {
        UserResponseDto response = userService.getById(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDto>> getAll() {
        List<UserResponseDto> responseList = userService.getAll();
        return ResponseEntity.ok(responseList);
    }


    @PutMapping("/actualizar/{id}")
    public ResponseEntity<UserResponseDto> update(@PathVariable Long id, @RequestBody UserRequestDto dto) {
        UserResponseDto response = userService.update(id, dto);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/login")
    public ResponseEntity<UserLoginResponseDto> login(@RequestBody UserLoginRequestDto dto) {
        UserLoginResponseDto response = userService.login(dto.getEmail(), dto.getContrasenia());
        return ResponseEntity.ok(response);
    }

}
