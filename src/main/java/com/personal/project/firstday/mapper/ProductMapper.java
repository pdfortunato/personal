package com.personal.project.firstday.mapper;

import com.personal.project.firstday.model.Product;
import com.personal.project.firstday.model.dto.ProductDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    Product fromDtoToEntity (ProductDto productDto);
    ProductDto fromEntityToDto (Product product);

    List<ProductDto> fromEntityToDto (List<Product> products);
}
