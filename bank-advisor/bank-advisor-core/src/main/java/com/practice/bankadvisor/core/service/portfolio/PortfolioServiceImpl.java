package com.practice.bankadvisor.core.service.portfolio;

import com.practice.bankadvisor.core.domain.Portfolio;
import com.practice.bankadvisor.core.domain.User;
import com.practice.bankadvisor.core.dto.PortfolioDto;
import com.practice.bankadvisor.core.mapper.PortfolioMapper;
import com.practice.bankadvisor.core.repository.PortfolioRepository;
import com.practice.bankadvisor.core.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PortfolioServiceImpl implements PortfolioService {

    private PortfolioRepository portfolioRepository;
    private UserRepository userRepository;

    @Autowired
    public PortfolioServiceImpl(PortfolioRepository portfolioRepository, UserRepository userRepository) {
        this.portfolioRepository = portfolioRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<PortfolioDto> findAll() {
        return PortfolioMapper.INSTANCE.toDtos(portfolioRepository.findAll());
    }

    @Override
    public PortfolioDto getSelectedPortfolio(Long id) {
        Portfolio portfolio = portfolioRepository.findById(id).orElse(null);
        return PortfolioMapper.INSTANCE.toDto(portfolio);
    }

    @Override
    public void removeUserFromPortfolio(Long portfolioId, Long userId) {

        Optional<Portfolio> portfolioOpt = portfolioRepository.findById(portfolioId);

        if(portfolioOpt.isPresent()) {
            Portfolio portfolio = portfolioOpt.get();
            User user = userRepository.findById(userId).orElse(null);
            if(user != null) {
                portfolio.getUsers().remove(user);
                portfolioRepository.save(portfolio);
            }
        }
    }
}
