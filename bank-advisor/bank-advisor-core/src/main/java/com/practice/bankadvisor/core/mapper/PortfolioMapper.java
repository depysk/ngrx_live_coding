package com.practice.bankadvisor.core.mapper;

import com.practice.bankadvisor.core.domain.Portfolio;
import com.practice.bankadvisor.core.dto.PortfolioDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = { UserMapper.class })
public interface PortfolioMapper {
    PortfolioMapper INSTANCE = Mappers.getMapper(PortfolioMapper.class);
    Portfolio toDomain(PortfolioDto dto);
    PortfolioDto toDto(Portfolio domain);
    List<PortfolioDto> toDtos(List<Portfolio> domains);
}
