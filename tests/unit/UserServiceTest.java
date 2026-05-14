package com.jrm.chronos.core.service;

import com.jrm.chronos.core.dto.UserDto;
import com.jrm.chronos.core.service.impl.UserServiceImpl;
import com.jrm.chronos.domain.repository.UserRepository;
import com.jrm.chronos.core.mapper.UserMapper;
import com.jrm.chronos.domain.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @Mock private UserRepository userRepository;
    @Mock private UserMapper userMapper;
    @InjectMocks private UserServiceImpl userService;

    @Test
    void findById_ExistingUser_ReturnsDto() {
        User user = new User();
        user.setId(1L);
        when(userRepository.findById(1L)).thenReturn(Optional.of(user));
        when(userMapper.toDto(user)).thenReturn(new UserDto());

        assertNotNull(userService.findById(1L));
    }
}
