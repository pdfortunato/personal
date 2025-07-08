package com.personal.project.firstday.repository;

import com.personal.project.firstday.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
