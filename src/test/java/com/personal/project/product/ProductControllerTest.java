package com.personal.project.product;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.personal.project.firstday.controller.ProductController;
import com.personal.project.firstday.model.dto.ProductDto;
import com.personal.project.firstday.service.ProductService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ProductController.class)
class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService productService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void shouldGetAllProducts() throws Exception {
        ProductDto product = new ProductDto();
        product.setId(1L);
        product.setName("Test Product");
        product.setPrice(9.99);

        Mockito.when(productService.getAll()).thenReturn(List.of(product));

        mockMvc.perform(get("/api/products"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1L))
                .andExpect(jsonPath("$[0].name").value("Test Product"))
                .andExpect(jsonPath("$[0].price").value(9.99));
    }

    @Test
    void shouldCreateProduct() throws Exception {
        ProductDto request = new ProductDto();
        request.setName("New Product");
        request.setPrice(5.0);

        ProductDto response = new ProductDto();
        response.setId(2L);
        response.setName("New Product");
        response.setPrice(5.0);

        Mockito.when(productService.createProduct(any(ProductDto.class))).thenReturn(response);

        mockMvc.perform(post("/api/products")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(2L))
                .andExpect(jsonPath("$.name").value("New Product"))
                .andExpect(jsonPath("$.price").value(5.0));
    }
}