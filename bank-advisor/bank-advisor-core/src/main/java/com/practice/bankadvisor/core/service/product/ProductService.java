package com.practice.bankadvisor.core.service.product;

import com.practice.bankadvisor.core.dto.ProductDto;

import java.util.List;

public interface ProductService {
    List<ProductDto> findAll();
    ProductDto getSelectedProduct(Long id);
}
