package com.practice.bankadvisor.core.service.portfolio;

import com.practice.bankadvisor.core.dto.PortfolioDto;

import java.util.List;

public interface PortfolioService {
    List<PortfolioDto> findAll();
    PortfolioDto getSelectedPortfolio(Long id);
    void removeUserFromPortfolio(Long portfolioId, Long userId);
}
