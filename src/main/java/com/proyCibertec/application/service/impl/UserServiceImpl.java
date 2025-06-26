package com.proyCibertec.application.service.impl;

import com.proyCibertec.application.mapper.UserMapper;
import com.proyCibertec.application.service.UserService;
import com.proyCibertec.domain.model.RolUser;
import com.proyCibertec.domain.model.User;
import com.proyCibertec.domain.repository.UserRepository;
import com.proyCibertec.web.dto.UserLoginResponseDto;
import com.proyCibertec.web.dto.UserRequestDto;
import com.proyCibertec.web.dto.UserResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final UserMapper mapper;


    @Override
    public UserResponseDto getById(Long id) {
        User user = repository.findById(id).orElseThrow(()->
                new RuntimeException("User no encontrado"));
        return mapper.toResponseDto(user);
    }

    @Override
    public UserResponseDto create(UserRequestDto dto) {
        User user = mapper.toEntity(dto);
        return mapper.toResponseDto(repository.save(user));
    }

    @Override
    public UserResponseDto update(Long id, UserRequestDto dto) {
        User existingUser = repository.findById(id).orElseThrow(() ->
                new RuntimeException("User no encontrado"));

        existingUser.setNombre(dto.getNombre());
        existingUser.setContrasenia(dto.getContrasenia());
        existingUser.setEmail(dto.getEmail());
        existingUser.setRol(RolUser.valueOf(dto.getRol()));

        return mapper.toResponseDto(repository.save(existingUser));
    }

    @Override
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("User no encontrado para eliminar");
        }
        repository.deleteById(id);
    }

    @Override
    public List<UserResponseDto> getAll() {
        List<User> usuarios = repository.findAll();
        List<UserResponseDto> lista = new ArrayList<>();
        for (User user : usuarios) {
            lista.add(mapper.toResponseDto(user));
        }
        return lista;
    }

    @Override
    public UserLoginResponseDto login(String email, String contrasenia) {
        User user = repository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        if (!user.getContrasenia().equals(contrasenia)) {
            throw new RuntimeException("Contraseña incorrecta");
        }

        return new UserLoginResponseDto(user.getRol().name());
    }

    @Override
    public UserResponseDto getUsuarioByEmail(String email) {
        Optional<User> optional = repository.findByEmail(email);
        if (optional.isEmpty()) {
            return null;
        }

        User user = optional.get();
        return new UserResponseDto(
                user.getId(),
                user.getNombre(),
                user.getEmail(),
                user.getContrasenia(),
                user.getRol().name());
    }

}
