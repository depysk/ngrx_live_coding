package com.practice.bankadvisor.core.repository;

import com.practice.bankadvisor.core.domain.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PortfolioRepository extends JpaRepository<Portfolio, Long> {
}
