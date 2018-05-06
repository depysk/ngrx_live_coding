package com.practice.bankadvisor.core.mapper;

import com.practice.bankadvisor.core.domain.Product;
import com.practice.bankadvisor.core.dto.ProductDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = { UserMapper.class })
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);
    Product toDomain(ProductDto dto);
    ProductDto toDto(Product domain);
    List<ProductDto> toDtos(List<Product> domains);
}
