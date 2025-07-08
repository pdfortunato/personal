package com.personal.project.firstday.controller;

import com.personal.project.firstday.mapper.ProductMapper;
import com.personal.project.firstday.model.dto.ProductDto;
import com.personal.project.firstday.repository.ProductRepository;
import com.personal.project.firstday.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductRepository productRepository;
    private  final ProductMapper productMapper;
    private final ProductService productService;

    public ProductController(ProductRepository productRepository, ProductMapper productMapper, ProductService productService) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public ProductDto getProduct(@PathVariable Long id) {
        return productService.getProduct(id);
    }

    @GetMapping
    public List<ProductDto> getAll(Pageable pageable) {
        return productService.getAll();
    }

    @PostMapping
    public ResponseEntity<String> addProduct(@Valid @RequestBody ProductDto productDto) {
        productRepository.save(productMapper.fromDtoToEntity(productDto));
        return ResponseEntity.ok().build();
    }

    @PutMapping()
    public ResponseEntity<String> updateProduct(@Valid @RequestBody ProductDto productDto) {
        productRepository.save(productMapper.fromDtoToEntity(productDto));
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
        productRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
