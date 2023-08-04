package com.springboot.apirest.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.apirest.crud.model.Product;
import com.springboot.apirest.crud.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;

	public List<Product> listProduct() {
		// Para retornar todos los registros que hay el la bd
		return repository.findAll();
	}

	public void saveProduct(Product product) {
		repository.save(product);
	}

	public Product getProductForId(Integer id) {
		return repository.findById(id).get();
	}

	public void deleteProduct(Integer id) {
		repository.deleteById(id);
	}
}
