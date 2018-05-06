package com.practice.bankadvisor.core.service.product;

import com.practice.bankadvisor.core.domain.Product;
import com.practice.bankadvisor.core.dto.ProductDto;
import com.practice.bankadvisor.core.mapper.ProductMapper;
import com.practice.bankadvisor.core.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductDto> findAll() {
        return ProductMapper.INSTANCE.toDtos(productRepository.findAll());
    }

    @Override
    public ProductDto getSelectedProduct(Long id) {
        Product product = productRepository.findById(id).orElse(null);
        return ProductMapper.INSTANCE.toDto(product);
    }
}
