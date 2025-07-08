package com.personal.project.firstday.model.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ProductDto {

    private long id;
    @NotBlank(message = "Il nome prodotto non può essere vuoto")
    private String name;

    @NotNull(message = "Il prezzo è obbligatorio")
    @Min(value = 1, message = "Il prezzo deve essere almeno 1")
    private Integer price;

    public ProductDto() {}

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getPrice() {
        return price;
    }
    public void setPrice(Integer price) {
        this.price = price;
    }
}
