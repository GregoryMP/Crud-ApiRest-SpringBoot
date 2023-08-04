package com.springboot.apirest.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.apirest.crud.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
