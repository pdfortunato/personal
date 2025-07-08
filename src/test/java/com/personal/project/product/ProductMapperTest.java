package com.personal.project.product;


import com.personal.project.firstday.mapper.ProductMapper;
import com.personal.project.firstday.model.Product;
import com.personal.project.firstday.model.dto.ProductDto;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductMapperTest {

    private final ProductMapper mapper = Mappers.getMapper(ProductMapper.class);

    @Test
    void shouldMapEntityToDto() {
        Product entity = new Product();
        entity.setId(1L);
        entity.setName("Test Product");
        entity.setPrice(19.99);

        ProductDto dto = mapper.fromEntityToDto(entity);

        assertEquals(entity.getId(), dto.getId());
        assertEquals(entity.getName(), dto.getName());
        assertEquals(entity.getPrice(), dto.getPrice());
    }

    @Test
    void shouldMapDtoToEntity() {
        ProductDto dto = new ProductDto();
        dto.setId(2L);
        dto.setName("Other Product");
        dto.setPrice(29.99);

        Product entity = mapper.fromDtoToEntity(dto);

        assertEquals(dto.getId(), entity.getId());
        assertEquals(dto.getName(), entity.getName());
        assertEquals(dto.getPrice(), entity.getPrice());
    }
}