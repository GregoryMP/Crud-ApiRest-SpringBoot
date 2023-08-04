package com.springboot.apirest.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.apirest.crud.model.Product;
import com.springboot.apirest.crud.service.ProductService;

@RestController
public class ProductController {
	@Autowired
	private ProductService service;

	@GetMapping("/product")
	public List<Product> listProduct() {
		return service.listProduct();
	}

	@GetMapping("/product/{id}")
	public ResponseEntity<Product> getProduct(@PathVariable Integer id) {
		try {
			Product product = service.getProductForId(id);
			return new ResponseEntity<Product>(product, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/product/insert")
	public void saveProduct(@RequestBody Product product) {
		service.saveProduct(product);
	}

	@PutMapping("/product/{id}")
	public ResponseEntity<?> updateProduct(@RequestBody Product product, @PathVariable Integer id) {
		try {
			Product getProduct = service.getProductForId(id);
			getProduct.setName(product.getName());
			getProduct.setPrice(product.getPrice());
			service.saveProduct(getProduct);
			return new ResponseEntity<Product>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/product/{id}")
	public void deleteProduct(@PathVariable Integer id) {
		service.deleteProduct(id);
	}

}
