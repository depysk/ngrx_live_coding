package com.practice.bankadvisor.core.repository;

import com.practice.bankadvisor.core.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
