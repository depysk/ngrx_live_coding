package com.practice.bankadvisor.core.service.user;

import com.practice.bankadvisor.core.domain.User;
import com.practice.bankadvisor.core.dto.UserDto;
import com.practice.bankadvisor.core.mapper.UserMapper;
import com.practice.bankadvisor.core.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserDto> findAll() {
        return null;
    }

    @Override
    public UserDto getSelectedUser(Long id) {
        return null;
    }

    @Override
    public UserDto updateUser(UserDto userDto) {
        User user = UserMapper.INSTANCE.toDomain(userDto);
        User savedUser = userRepository.save(user);
        return UserMapper.INSTANCE.toDto(savedUser);
    }

}
