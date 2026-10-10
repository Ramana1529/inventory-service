package com.example.inventory_service.mapper;

import com.example.inventory_service.dto.ProductRequestDTO;
import com.example.inventory_service.dto.ProductResponseDTO;
import com.example.inventory_service.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    public Product toEntity(ProductRequestDTO productRequestDTO){
        Product product = new Product();
        product.setSku(productRequestDTO.getSku());
        product.setName(productRequestDTO.getName());
        product.setDescription(productRequestDTO.getDescription());
        product.setPrice(productRequestDTO.getPrice());
        return product;
    }
    public ProductResponseDTO toResponseDTO(Product product){
        ProductResponseDTO productResponseDTO = new ProductResponseDTO();
        productResponseDTO.setId(product.getId());
        productResponseDTO.setName(product.getName());
        productResponseDTO.setSku(product.getSku());
        productResponseDTO.setDescription(product.getDescription());
        productResponseDTO.setPrice(product.getPrice());
        productResponseDTO.setActive(product.getActive());
        productResponseDTO.setCreatedAt(product.getCreatedAt());
        productResponseDTO.setUpdatedAt(product.getUpdatedAt());
        return productResponseDTO;
    }
}
