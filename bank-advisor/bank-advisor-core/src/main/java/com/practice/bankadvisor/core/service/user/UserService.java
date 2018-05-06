package com.practice.bankadvisor.core.service.user;

import com.practice.bankadvisor.core.dto.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> findAll();
    UserDto getSelectedUser(Long id);
    UserDto updateUser(UserDto userDto);
}
