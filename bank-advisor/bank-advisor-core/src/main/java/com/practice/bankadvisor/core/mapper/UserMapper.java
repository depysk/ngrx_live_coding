package com.practice.bankadvisor.core.mapper;

import com.practice.bankadvisor.core.domain.User;
import com.practice.bankadvisor.core.dto.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = { LocalDateMapper.class })
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    User toDomain(UserDto dto);
    UserDto toDto(User domain);
}
