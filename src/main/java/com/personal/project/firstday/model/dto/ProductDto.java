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
    private Double price;

    public ProductDto() {}

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
}
