package com.jrm.chronos.core.service.impl;

import com.jrm.chronos.core.dto.UserDto;
import com.jrm.chronos.core.mapper.UserMapper;
import com.jrm.chronos.core.service.UserService;
import com.jrm.chronos.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final com.jrm.chronos.domain.repository.RoleRepository roleRepository;
    private final UserMapper userMapper;
    private final org.springframework.security.crypto.password.PasswordEncoder passwordEncoder;

    @Override
    public UserDto findById(Long id) {
        return userRepository.findById(id)
                .map(userMapper::toDto)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }

    @Override
    public UserDto findByUsername(String username) {
        return userRepository.findByUsername(username)
                .map(userMapper::toDto)
                .orElseThrow(() -> new RuntimeException("User not found with username: " + username));
    }

    @Override
    public List<UserDto> findAll() {
        return userRepository.findAll().stream()
                .map(userMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public UserDto createUser(com.jrm.chronos.core.dto.UserCreateDto userCreateDto) {
        if (userRepository.existsByUsername(userCreateDto.getUsername())) {
            throw new RuntimeException("Username already exists");
        }
        if (userRepository.existsByEmail(userCreateDto.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        com.jrm.chronos.domain.User user = com.jrm.chronos.domain.User.builder()
                .username(userCreateDto.getUsername())
                .email(userCreateDto.getEmail())
                .password(passwordEncoder.encode(userCreateDto.getPassword()))
                .enabled(true)
                .build();

        if (userCreateDto.getRoles() != null) {
            java.util.Set<com.jrm.chronos.domain.Role> roles = userCreateDto.getRoles().stream()
                    .map(roleName -> roleRepository.findByName(roleName)
                            .orElseThrow(() -> new RuntimeException("Role not found: " + roleName)))
                    .collect(Collectors.toSet());
            user.setRoles(roles);
        }

        return userMapper.toDto(userRepository.save(user));
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}
