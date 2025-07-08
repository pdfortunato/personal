package com.personal.project.product;

import com.personal.project.firstday.mapper.ProductMapper;
import com.personal.project.firstday.model.Product;
import com.personal.project.firstday.model.dto.ProductDto;
import com.personal.project.firstday.repository.ProductRepository;
import com.personal.project.firstday.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ProductServiceTest {

    private ProductService productService;
    private ProductRepository productRepository;
    private final ProductMapper productMapper = Mappers.getMapper(ProductMapper.class);

    @BeforeEach
    void setUp() {
        productRepository = mock(ProductRepository.class);
        productService = new ProductService(productRepository, productMapper);
    }

    @Test
    void shouldReturnAllProducts() {
        Product product = new Product();
        product.setId(1L);
        product.setName("Test");
        product.setPrice(9.99);

        when(productRepository.findAll()).thenReturn(List.of(product));

        List<ProductDto> result = productService.getAll();

        assertEquals(1, result.size());
        assertEquals("Test", result.get(0).getName());
    }

    @Test
    void shouldSaveProduct() {
        ProductDto dto = new ProductDto();
        dto.setName("New Product");
        dto.setPrice(5.0);

        Product entity = productMapper.fromDtoToEntity(dto);
        Product savedEntity = new Product();
        savedEntity.setId(1L);
        savedEntity.setName("New Product");
        savedEntity.setPrice(5.0);

        when(productRepository.save(any(Product.class))).thenReturn(savedEntity);

        ProductDto result = productService.createProduct(dto);

        assertEquals("New Product", result.getName());
        assertEquals(5.0, result.getPrice());
        assertNotNull(result.getId());
    }
}