package com.personal.project.firstday.service;

import com.personal.project.firstday.mapper.ProductMapper;
import com.personal.project.firstday.model.Product;
import com.personal.project.firstday.model.dto.ProductDto;
import com.personal.project.firstday.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductService(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    public List<ProductDto> getAll() {
        List<Product> products = productRepository.findAll();
        return products.isEmpty() ? Collections.emptyList() : productMapper.fromEntityToDtoList(products);
    }

    public ProductDto createProduct(ProductDto productDto) {
        return productMapper.fromEntityToDto(productRepository.save(productMapper.fromDtoToEntity(productDto)));
    }

    public ProductDto updateProduct(ProductDto productDto) {
        return productMapper.fromEntityToDto(productRepository.save(productMapper.fromDtoToEntity(productDto)));
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    public ProductDto getProduct(Long id) {
        return productMapper.fromEntityToDto(productRepository.findById(id).orElseThrow());
    }
}
