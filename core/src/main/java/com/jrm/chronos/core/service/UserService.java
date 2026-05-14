package com.jrm.chronos.core.service;

import com.jrm.chronos.core.dto.UserDto;
import java.util.List;

public interface UserService {
    UserDto findById(Long id);
    UserDto findByUsername(String username);
    List<UserDto> findAll();
    UserDto createUser(com.jrm.chronos.core.dto.UserCreateDto userCreateDto);
    void deleteById(Long id);
}
