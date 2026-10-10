package com.example.inventory_service.service;

import com.example.inventory_service.dto.ProductRequestDTO;
import com.example.inventory_service.dto.ProductResponseDTO;
import com.example.inventory_service.entity.Product;
import com.example.inventory_service.mapper.ProductMapper;
import com.example.inventory_service.repository.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ProductService {
    private final ProductMapper productMapper;
    private final ProductRepository productRepository;

    public ProductService(ProductMapper productMapper, ProductRepository productRepository) {
        this.productMapper = productMapper;
        this.productRepository = productRepository;
    }
    public ProductResponseDTO createProduct(ProductRequestDTO productRequestDTO){
        if(productRepository.existsBySku(productRequestDTO.getSku())){
            throw new ResponseStatusException(HttpStatus.CONFLICT,"Product with this SKU already exists");
        }
        Product product = productMapper.toEntity(productRequestDTO);
        Product savedProduct = productRepository.save(product);
        return productMapper.toResponseDTO(savedProduct);
    }
}
